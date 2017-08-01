package demo;

/**
 * @author: wangruirui
 * @date: 2017/7/31
 * @description:
 */
public class ThreadDemo {
    private volatile  static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while(flag){
                    try {
                        System.out.println("运行中1");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while(flag){
                    try {
                        System.out.println("运行中2");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = false;
                }
            }
        };
        thread.start();
        thread2.start();
        Thread.sleep(3000);
        flag = false;

    }
}
