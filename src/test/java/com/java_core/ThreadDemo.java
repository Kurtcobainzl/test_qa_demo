package com.java_core;

import org.apache.commons.codec.binary.Hex;
import sun.nio.cs.SingleByte;

public class ThreadDemo extends Thread {

    ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    ThreadLocal<String> threadLocal2 = new ThreadLocal<String>();

    @Override
    public void run() {
        super.run();
        threadLocal1.set("hello");
        threadLocal2.set("world");


        System.out.println(Thread.currentThread().getName() + "---" + threadLocal1.get() + "===" + threadLocal2.get());

    }


    public static void main(String[] args) {


        byte[] bytes=new byte[100];
        for (int i =0;i<bytes.length;i++){
            bytes[i]= (byte) i;
        }


        System.out.println(""+  Hex.encodeHexString(bytes));



//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();
//        for (int i = 0; i < 10; i++) {
//            new ThreadDemo().start();
//        }

    }
}
