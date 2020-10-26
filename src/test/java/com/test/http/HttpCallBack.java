package com.test.http;


/**
 * 网络请求回调
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
