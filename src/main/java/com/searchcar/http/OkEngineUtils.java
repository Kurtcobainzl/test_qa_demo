package com.searchcar.http;

import okhttp3.FormBody;
import okhttp3.Headers;

import java.util.Map;

/**
 * 对请求参数进行一些封装的工具类
 */
public class OkEngineUtils {

    /**
     * @param header
     * @return 获取网络请求的header(以okhttp的Headers格式)
     */
    public static Headers  getHeaders(Map<String, String> header) {
        Headers.Builder headerB = new Headers.Builder();
        if (header != null && header.size() != 0) {
            for (String key : header.keySet()) {
                headerB.add(key, header.get(key));
            }
        }
        return headerB.build();
    }

    public static FormBody.Builder getFormBodyBuilder(Map<String, Object> params) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key) + "");
            }
        }
        return builder;
    }

    /**
     * @param url
     * @param params
     * @return get请求中，将参数拼接到url后面
     */
    public static String  getUrlWithParams(String url, Map<String, Object> params) {
        if (params == null || params.size() <= 0) {
            return url;
        }

        StringBuffer stringBuffer = new StringBuffer(url);
        if (!url.contains("?")) {
            stringBuffer.append("?");
        } else {
            if (!url.endsWith("?")) {
                stringBuffer.append("&");
            }
        }

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            stringBuffer.append(entry.getKey() + "=" + entry.getValue() + "&");
        }

        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }
}
