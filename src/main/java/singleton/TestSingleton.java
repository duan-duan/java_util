package singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @author: wangruirui
 * @date: 2017/8/18
 * @description: 测试
 */
public class TestSingleton {
    public static void main(String[] args){
        //启动20个线程同时去抢cpu
        int count = 20;
        //发令枪
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count ; i++) {
            Singleton4 singleton4 = Singleton4.getInstance();
            new Thread(){
                public void run(){
                    System.out.println(System.currentTimeMillis()+""+Singleton4.getInstance());
                }
            }.start();
            //等待法令
            latch.countDown();
        }
        try {
            latch.await();//发令枪发令，开始抢CPU
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
