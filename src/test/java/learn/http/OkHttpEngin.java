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
        client.dispatcher().setMaxRequests(10);//ÿ���˿��������������

    }
/**
 * get�����װ
 * @param url        ���������ַ
 * @param param      �������
 * @param headers    header����
 */
    public String get(String url, Map<String ,Object> param, Map<String,String> headers){
        Request request = new Request.Builder().headers(OkEnginUtils.getHeaders(headers)).url(OkEnginUtils.getUrlWithParams(url,param)).get().build();
       String result= clientCall(request);
       return result;
    }

    /**
     * PUT����  form����ʽ  ������֤�ɵ�ͨ��
     *
     * @param url      ���������ַ
     * @param params   put����body����
     * @param headers  put����header����
     * @param callBack ��������ص�
     */
    public void put(String url,Map<String ,Object> params,Map<String,String > headers,final HttpCallBack callBack){
        FormBody.Builder builder = OkEnginUtils.getFormBodyBuilder(params);
        RequestBody formBody = builder.build();
        Request request = new Request.Builder().headers(OkEnginUtils.getHeaders(headers)).url(url).put(formBody).build();
        clientCall(request);
    }

    /**
     *put���� json����ʽ
     * @param  url             ���������ַ
     * @param  jsonContent     json��ʽ���ַ���
     * @param headers           put����header����
     * @param callBack          ��������ص�
     */

    public void putJson(String url, @NotNull String jsonContent, Map<String ,String> headers, final HttpCallBack callBack){
        RequestBody body = FormBody.create(MediaType.parse("application/json; charset=utf-8"),jsonContent);
        Request request = new Request.Builder().headers(OkEnginUtils.getHeaders(headers)).url(url).put(body).build();
        clientCall(request);
    }
    /**
     * post���� json����ʽ
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
