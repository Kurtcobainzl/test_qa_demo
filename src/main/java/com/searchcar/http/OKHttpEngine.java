package com.searchcar.http;

import com.sun.istack.internal.NotNull;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * 网络请求封装类
 */
public class OKHttpEngine {

    private static long TIMEOUT = 30L;  //接口请求超时时间
    OkHttpClient client;

    public OKHttpEngine() {
        client = new OkHttpClient.Builder().readTimeout(TIMEOUT, TimeUnit.SECONDS).build();
        client.dispatcher().setMaxRequestsPerHost(10);

    }

    /**
     * GET请求
     *
     * @param url      网络请求地址
     * @param params   请求参数
     * @param headers  header参数
     * @param callBack 回调方法
     */
    public void get(String url, Map<String, Object> params, Map<String, String> headers, HttpCallBack callBack) {
        Request request = new Request.Builder().headers(OkEngineUtils.getHeaders(headers)).url(OkEngineUtils.getUrlWithParams(url, params)).get().build();
        clientCall(request, callBack);
    }


    /**
     * PUT请求  form请求方式  （已验证可调通）
     *
     * @param url      网络请求地址
     * @param params   put请求body参数
     * @param headers  put请求header参数
     * @param callBack 网络请求回调
     */
    public void put(String url, Map<String, Object> params, Map<String, String> headers, final HttpCallBack callBack) {
        FormBody.Builder builder = OkEngineUtils.getFormBodyBuilder(params);
        RequestBody formBody = builder.build();
        Request request = new Request.Builder().headers(OkEngineUtils.getHeaders(headers)).url(url).put(formBody).build();
        clientCall(request, callBack);
    }


    /**
     * PUT请求 json请求方式 （未验证）
     *
     * @param url         网络请求地址
     * @param jsonContent json格式的字符串  eg:   {"key":value,"key2":value2}
     * @param headers     put请求header参数
     * @param callBack    网络请求回调
     */
    public void putJson(String url, @NotNull String jsonContent, Map<String, String> headers, final HttpCallBack callBack) {
        RequestBody body = FormBody.create(MediaType.parse("application/json; charset=utf-8"), jsonContent);
        Request request = new Request.Builder().headers(OkEngineUtils.getHeaders(headers)).url(url).put(body).build();
        clientCall(request, callBack);
    }

    /**
     * POST请求  form请求方式  （未验证）
     *
     * @param url      网络请求地址
     * @param params   post请求body参数
     * @param headers  post请求header参数
     * @param callBack 网络请求回调
     */
    public void post(String url, Map<String, Object> params, Map<String, String> headers, final HttpCallBack callBack) {
        FormBody.Builder builder = OkEngineUtils.getFormBodyBuilder(params);
        RequestBody formBody = builder.build();
        Request request = new Request.Builder().headers(OkEngineUtils.getHeaders(headers)).url(url).post(formBody).build();
        clientCall(request, callBack);
    }

    /**
     * POST请求 json请求方式 （未验证）
     *
     * @param url         网络请求地址
     * @param jsonContent json格式的字符串  eg:   {"key":value,"key2":value2}
     * @param headers     post请求header参数
     * @param callBack    网络请求回调
     */
    public void postJson(String url, @NotNull String jsonContent, Map<String, String> headers, final HttpCallBack callBack) {
        RequestBody body = null;
        body = FormBody.create(MediaType.parse("application/json; charset=utf-8"), jsonContent);
        Request request = new Request.Builder().headers(OkEngineUtils.getHeaders(headers)).url(url).post(body).build();
        clientCall(request, callBack);
    }


    /**
     * DELETE 请求
     *
     * @param url      网络请求地址
     * @param params   body参数
     * @param headers  header参数
     * @param callBack 网络请求回调
     */
    public void delete(String url, Map<String, Object> params, Map<String, String> headers, final HttpCallBack callBack) {
        Request request = new Request.Builder().headers(OkEngineUtils.getHeaders(headers)).url(OkEngineUtils.getUrlWithParams(url, params)).delete().build();
        clientCall(request, callBack);
    }


    /**
     * 发起网络请求&请求结果回调
     *
     * @param request
     * @param callBack
     */
    private void clientCall(Request request, final HttpCallBack callBack) {
        try {
            callBack.onStart();
            client.newCall(request).enqueue(new Callback() {
                public void onFailure(Call call, IOException e) {
                    callBack.onFail(e.getMessage());
                    callBack.onFinish();
                }

                public void onResponse(Call call, Response response) throws IOException {
                    String json = response.body().string();
                    callBack.onSuccess(json);
                }
            });
        } catch (Exception e) {
            callBack.onFail(e.getMessage());
        } finally {
            callBack.onFinish();
        }
    }


}
