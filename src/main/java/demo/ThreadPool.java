package demo;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author: wangruirui
 * @date: 2017/11/15
 * @description:
 */

public class ThreadPool {
    public static void main(String[] args) {
        //创建固定大小线程池
        ExecutorService executor = newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            SendNoticeTask task = new SendNoticeTask();
            task.setCount(i);
            executor.execute(task);
        }
        System.out.println("主线程结束");
    }
}
//测试类：SendNoticeTask，执行任务类，就是打印一句当前线程名+第几个任务。为了方便观察，每个线程执行完以后睡10s。
