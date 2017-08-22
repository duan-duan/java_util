package io;

import java.io.*;

/**
 * @author: wangruirui
 * @date: 2017/8/22
 * @description:
 */
public class FileIOTest {
    public static void main(String[] args){
        //输出
        File file = new File("file.txt");
        String str = "hahaha111";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //输入
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStream.read(bytes);
            System.out.println(new String(bytes,0,bytes.length));
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


