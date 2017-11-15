package demo;

/**
 * @author: wangruirui
 * @date: 2017/11/15
 * @description:
 */
//测试类：SendNoticeTask，执行任务类，就是打印一句当前线程名+第几个任务。为了方便观察，每个线程执行完以后睡10s。
public class SendNoticeTask implements Runnable {
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start to" + " send " + count + " ...");
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish " + Thread.currentThread().getName());
    }
}


