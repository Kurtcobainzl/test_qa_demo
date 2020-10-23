import com.searchcar.base.BaseConfig;
import com.searchcar.bean.TestBean;
import com.searchcar.http.HttpCallBack;
import com.searchcar.http.MyHttpCallBack;
import com.searchcar.http.OKHttpEngine;
import com.searchcar.http.OkEngineUtils;
import com.searchcar.utils.MD5Utils;
import okhttp3.*;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * 测试网络请求  ：发送验证码接口+验证码登录接口
 */
public class TestLogin extends BaseConfig {
    private static final String salt = "NR8DeCTBfCzTvNGL";//伪加盐，只为混淆数据

    static String phone = "18910901200";


    public static void main(String[] args) {
        new TestLogin().getSms();
    }

    /**
     * 发起请求，走发送验证码接口
     * signature: md5加验证
     */
    public static void getSms() {
        long timestamp = System.currentTimeMillis() / 1000;
        String signature = MD5Utils.MD5Encode(MD5Utils.MD5Encode(timestamp + phone, "utf8") + salt, "utf8");
        String url = "http://test-api.i-morefun.com/sms/v1/smsCode/" + phone;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("timestamp", "10101010");//测试环境不校验，值随便写。
        params.put("signature", signature);
        new OKHttpEngine().get(url, params, getCommonHeaders(), new HttpCallBack() {//使用默认的回调，返回string  自行处理
            @Override
            public void onSuccess(String str) {
                System.out.println("succ:" + str);
                Login();
            }

            @Override
            public void onFail(String failMsg) {
                super.onFail(failMsg);
                System.out.println("failMsg:" + failMsg);
            }
        });


    }

    /**
     * 走登录接口
     */
    public static void Login() {

        String url = "http://test-api.i-morefun.com/app_login/v1/login";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("code", "1234");
        params.put("phone", phone);

        new OKHttpEngine().put(url, params, null, new MyHttpCallBack<TestBean>() {
            public void onSucc(TestBean result) {
                System.out.println("onSucc:"+result);
            }

            @Override
            public void onFail(String failMsg) {
                super.onFail(failMsg);
                System.out.println("onFail:" + failMsg);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                System.out.println("onFinish");

            }
        });
    }

}
