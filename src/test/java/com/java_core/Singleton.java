package com.java_core;

public class Singleton {


    private Singleton(){
    }

    private static class SingletonHolder{
        public static volatile Singleton instance=new Singleton();

    }
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
