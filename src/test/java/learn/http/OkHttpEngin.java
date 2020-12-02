package learn.http;

import com.sun.istack.internal.NotNull;
import wss.http.HttpCallBack;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttpEngin {
    private static Long TIMEOUT = 30L;
    OkHttpClient client;

    public  OkHttpEngin(){
        client = new OkHttpClient.Builder().readTimeout(TIMEOUT, TimeUnit.SECONDS).build();
        client.dispatcher().setMaxRequests(10);//每个端口设置最大请求数

    }
/**
 * get请求封装
 * @param url        网络请求地址
 * @param param      请求参数
 * @param headers    header参数
 */
    public String get(String url, Map<String ,Object> param, Map<String,String> headers){
        Request request = new Request.Builder().headers(OkEnginUtils.getHeaders(headers)).url(OkEnginUtils.getUrlWithParams(url,param)).get().build();
       String result= clientCall(request);
       return result;
    }

    /**
     * PUT请求  form请求方式  （已验证可调通）
     *
     * @param url      网络请求地址
     * @param params   put请求body参数
     * @param headers  put请求header参数
     * @param callBack 网络请求回调
     */
    public void put(String url,Map<String ,Object> params,Map<String,String > headers,final HttpCallBack callBack){
        FormBody.Builder builder = OkEnginUtils.getFormBodyBuilder(params);
        RequestBody formBody = builder.build();
        Request request = new Request.Builder().headers(OkEnginUtils.getHeaders(headers)).url(url).put(formBody).build();
        clientCall(request);
    }

    /**
     *put请求 json请求方式
     * @param  url             网络请求地址
     * @param  jsonContent     json格式的字符串
     * @param headers           put请求header参数
     * @param callBack          网络请求回调
     */

    public void putJson(String url, @NotNull String jsonContent, Map<String ,String> headers, final HttpCallBack callBack){
        RequestBody body = FormBody.create(MediaType.parse("application/json; charset=utf-8"),jsonContent);
        Request request = new Request.Builder().headers(OkEnginUtils.getHeaders(headers)).url(url).put(body).build();
        clientCall(request);
    }
    /**
     * post请求 json请求方式
     * @param url
     * @param
     */
    public void  postJson(String url, String jsonContent,Map<String,String > headers,final HttpCallBack callBack) {
        RequestBody formBody =  FormBody.create(MediaType.parse("application/json; charset=utf-8"),jsonContent);
        Request request = new Request.Builder().headers(OkEnginUtils.getHeaders(headers)).url(url).post(formBody).build();
        clientCall(request);
    }

//    }

    public String clientCall(Request request){
        try{
//            callBack.onStart();
            Response response = client.newCall(request).execute();
            String json = response.body().string();
            return json;
//            callBack.onSuccess(json);
        } catch (IOException e) {
            e.printStackTrace();
//            callBack.onFail(e.getMessage());
        }finally {
//            callBack.onFinish();

        }
return "";
    }

}
