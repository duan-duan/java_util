package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wangruirui
 * @date: 2017/8/18
 * @description:
 */
public class ReentrantLockTest  implements Runnable{
    private static final School school = new School(0);
    private static ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i <10000 ; i++) {
            try {
                reentrantLock.lock();
                add();
            }finally {
                reentrantLock.unlock();
            }
        }
    }
    private static synchronized void add() {
        int student = school.getStrudent();
        student++;
        school.setStrudent(student);
    }
    public static void main(String[] args){
        ReentrantLockTest lockTest1 = new ReentrantLockTest();

        ReentrantLockTest lockTest2 = new ReentrantLockTest();

        Thread t1 = new Thread(lockTest1);
        Thread t2 = new Thread(lockTest2);
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
