package learn.base;

import java.util.HashMap;
import java.util.Map;


/**
 * ����һЩͨ�÷���
 */
public class BaseConfig {


    /**
     * ͨ��header
     *
     * @return
     */
    public static Map<String, String> getCommonHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "48560ef7-2832-471e-8b87-69801bfc4be3");
        headers.put("X-APPLICATION-ID", "DMO");//test
        return headers;
    }


    /**
     * ����������Ե���header����
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
