package com.test.base;

import java.util.HashMap;
import java.util.Map;


/**
 * 设置一些通用方法
 */
public class BaseConfig {


    /**
     * 通用header
     *
     * @return
     */
    public static Map<String, String> getCommonHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("token", "abcdefg");//test   参数随便写的。
        headers.put("id", "1234567");//test
        headers.put("system", "android");//test
        headers.put("imei", "sadasdsdzfghfdgcvrvxfvdfs");//test
        return headers;
    }


    /**
     * 根据需求可以调整header内容
     *
     * @param token
     * @param phone
     * @return
     */
    public static Map<String, String> getLoginHeaders(String token, String phone) {
        Map<String, String> headers = getCommonHeaders();
        headers.put("token", token);//test
        headers.put("phone", phone);
        return headers;
    }


}
