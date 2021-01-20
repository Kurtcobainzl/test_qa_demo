package com.java_core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class InvokeList {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        try {
            Method method = list.getClass().getMethod("add", Object.class);
            method.invoke(list, "this is a String");
            System.out.println(list.get(0));//this is a String
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
