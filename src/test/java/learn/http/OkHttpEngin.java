package learn.http;

import com.sun.istack.internal.NotNull;
import okhttp3.*;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttpEngin {
    private static Long TIMEOUT = 30L;
    OkHttpClient client;

    public  OkHttpEngin(){
        client = new OkHttpClient.Builder()
        .sslSocketFactory(createSSLSocketFactory())
        .hostnameVerifier(new TrustAllHostnameVerifier())
.readTimeout(TIMEOUT, TimeUnit.SECONDS).build();
        client.dispatcher().setMaxRequests(10);//每个端口设置最大请求数

    }
/**
 * get请求封装
 * @param url        网络请求地址
 * @param param      请求参数
 * @param headers    header参数
 */
    public String get(String url, Map<String ,Object> param, Map<String,String> headers){
        String myUrl=OkEnginUtils.getUrlWithParams(url,param);
        Request request = new Request.Builder().headers(OkEnginUtils.getHeaders(headers)).url(myUrl).get().build();
       String result= clientCall(request);
       return result;
    }

    /**
     * PUT请求  form请求方式  （已验证可调通）
     *
     * @param url      网络请求地址
     * @param params   put请求body参数
     * @param headers  put请求header参数
     */
    public void put(String url,Map<String ,Object> params,Map<String,String > headers){
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
     */

    public void putJson(String url, @NotNull String jsonContent, Map<String ,String> headers){
        RequestBody body = FormBody.create(MediaType.parse("application/json; charset=utf-8"),jsonContent);

        Request request = new Request.Builder().headers(OkEnginUtils.getHeaders(headers)).url(url).put(body).build();
        clientCall(request);
    }
    /**
     * post请求 json请求方式
     * @param
     * @param url
     * @return
     */
    public String postJson(String url, String jsonContent, Map<String,String > headers) {

        RequestBody formBody =  FormBody.create(MediaType.parse("application/json; charset=utf-8"),jsonContent);
        Request request = new Request.Builder().headers(OkEnginUtils.getHeaders(headers)).url(url).post(formBody).build();
        return clientCall(request);
    }


    public String clientCall(Request request){
        try{
            Response response = client.newCall(request).execute();
            String json = response.body().string();
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }



    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null,  new TrustManager[] { new TrustAllCerts() }, new java.security.SecureRandom());

            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }

        return ssfFactory;
    }






    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }



    private static class TrustAllCerts implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
//        @Override
//        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
//
//        @Override
//        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
//
//        @Override
//        public X509Certificate[] getAcceptedIssuers() {return new X509Certificate[0];}
    }







}
