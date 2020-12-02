package com.test.http;


/**
 * 网络请求回调
 * abstract 抽象类
 * 里面是抽象方法
 */
public abstract class HttpCallBack {
    public void onStart() {

    }

    public abstract void onSuccess(String str);

    public void onFail(String failMsg) {

    }

    public void onFinish() {

    }

}
