package com.test.http;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.ParameterizedType;


/**
 * 根据接口规范 在原回调上再封装一层。
 *
 * @param <T>
 */
public abstract class MyHttpCallBack<T> extends HttpCallBack {

    public void onSuccess(String str) {


//eg        {
//            "code":200, "desc":"OK", "modelData":{
//            "token":
//            "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTE3MjUzMCIsImV4cCI6MTYyMTU2ODY5NSwiaWF0IjoxNjAzNDI0Njk1fQ.b5wHTFnNUS76Gqq6n4J_x6cIgtO7A8vq8ciW5Pb1O7Z0UxqdhwGtzf-wNkrn2QYCi38FtH0qL5B24Wiq2fruCg"
//        }
//        }

        System.out.println(str);

        JsonObject object = new JsonParser().parse(str).getAsJsonObject();  //字符串转json

        final int code = object.get("code").getAsInt();
        final String desc = object.get("desc").getAsString();
        final String modelData = object.get("modelData").toString();

        if (code != 200) {
            onFail(desc);
        } else {
            T bean = (T) new Gson().fromJson(modelData, getInstanceOfT().getClass());
            onSucc(bean);
        }
    }


    public abstract void onSucc(T result);


    @Override
    public void onFail(String failMsg) {
        super.onFail(failMsg);
    }

    /**
     * 通过反射获取到T的类型
     *
     * @return
     */
    private T getInstanceOfT() {
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> type = (Class<T>) superClass.getActualTypeArguments()[0];
        try {
            return type.newInstance();
        } catch (Exception e) {
            // Oops, no default constructor
            throw new RuntimeException(e);
        }
    }

}
