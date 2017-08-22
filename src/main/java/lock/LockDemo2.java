package lock;

/**
 * @author: wangruirui
 * @date: 2017/8/18
 * @description:
 */
public class LockDemo2 implements Runnable{
    private static final School school = new School(0);
    @Override
    public void run() {
        for (int i = 0; i <10000 ; i++) {
            add();
        }
    }
    private static synchronized void add() {
        int student = school.getStrudent();
        student++;
        school.setStrudent(student);
    }
    public static void main(String[] args){
        LockDemo2 lockDemo1 = new LockDemo2();

        LockDemo2 lockDemo2 = new LockDemo2();

        Thread t1 = new Thread(lockDemo1);
        Thread t2 = new Thread(lockDemo2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.print(school.getStrudent());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
