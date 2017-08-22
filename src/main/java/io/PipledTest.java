package io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author: wangruirui
 * @date: 2017/8/22
 * @description:
 */
public class PipledTest {

    public static void main(String[] args) {
        Send send = new Send();
        Recive recive = new Recive();
        Thread s = new Thread(send);
        Thread r = new Thread(recive);
        try {
            send.getPipedOutputStream().connect(recive.getPipedInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        s.start();
        r.start();


    }
}


class Send implements Runnable{

    private PipedOutputStream pipedOutputStream = null;

    public Send(){
        pipedOutputStream = new PipedOutputStream();
    }
    public PipedOutputStream getPipedOutputStream(){
        return  pipedOutputStream;
    }


    @Override
    public void run() {
        String str = "hello ,I am send";
        try {
            pipedOutputStream.write(str.getBytes());
            pipedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

class Recive implements Runnable{

    private PipedInputStream pipedInputStream = null;

    public Recive(){
        pipedInputStream = new PipedInputStream();
    }

    public PipedInputStream getPipedInputStream(){
        return  pipedInputStream;
    }

    @Override
    public void run() {
        byte[] bytes = new byte[1000];
        int len = 0;
        try {
            len = pipedInputStream.read(bytes);
            pipedInputStream.close();
            System.out.println("收到数据：" + new String(bytes,0,len));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
