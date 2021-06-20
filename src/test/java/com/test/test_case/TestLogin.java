package com.test.test_case;

import com.test.base.BaseConfig;
import com.test.bean.TestBean;
import com.test.http.HttpCallBack;
import com.test.http.MyHttpCallBack;
import com.test.http.OKHttpEngine;
import com.test.data_provider.TestParam;
import com.test.utils.ExcelUtil;
import com.test.utils.MD5Utils;
import com.test.utils.StringUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 测试网络请求  ：发送验证码接口+验证码登录接口
 */
public class TestLogin extends BaseConfig {
    private static final String salt = "NR8DeCTBfCzTvNGL";//伪加盐，只为混淆数据
    /**
     * 发起请求，走发送验证码接口
     * signature: md5加验证
     */

    SoftAssert softAssert = new SoftAssert();


    @Test(description = "获取短信验证码", priority = 1, dataProvider = "getPhones", dataProviderClass = TestParam.class)
    public void getSms(final String phone) throws Exception {

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
                Login(phone);
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
    public void Login(String phone) {

        String url = "http://test-api.i-morefun.com/app_login/v1/login";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("code", "1234");
        params.put("phone", phone);

        new OKHttpEngine().put(url, params, null, new MyHttpCallBack<TestBean>() {
            public void onSucc(TestBean result) {
                System.out.println("onSucc:" + result);
                softAssert.assertTrue(!StringUtils.isEmpty(result.token));//  软断言
            }

            @Override
            public void onFail(String failMsg) {
                super.onFail(failMsg);
                System.out.println("onFail:" + failMsg);
//                Assert.assertTrue(false); //硬断言
            }

            @Override
            public void onFinish() {
                super.onFinish();
                System.out.println("onFinish");
                softAssert.assertAll();   //软断言。对象收集错误信息，最后通过assertAll 发送出去。如果没有这句，前面的白收集了
            }
        });
    }

}
