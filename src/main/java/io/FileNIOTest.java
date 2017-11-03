package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: wangruirui
 * @date: 2017/8/23
 * @description:
 */
public class FileNIOTest {
    public static void main(String[] args){
        try {
            RandomAccessFile file = new RandomAccessFile("file.txt","rw");
            FileChannel fileChannel = file.getChannel();
            //48个字节的缓存区
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int read = fileChannel.read(byteBuffer);
            while(-1 != read){
                //标记buffer为可读状态
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()){
                    System.out.println((char) byteBuffer.get());
                }
                //标记buffer为可写状态
                byteBuffer.clear();

                read = fileChannel.read(byteBuffer);


            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
