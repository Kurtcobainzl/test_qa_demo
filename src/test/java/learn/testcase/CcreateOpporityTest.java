package learn.testcase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import learn.base.BaseUrl;
import learn.bean.User;
import learn.http.OkHttpEngin;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import static learn.base.BaseConfig.getCommonHeaders;

public class CcreateOpporityTest {
    //    �����ѯ�Ƿ��п͵�
    @Test(description = "��ȡ������֤��", priority = 1, dataProvider = "getPhones", dataProviderClass = TestParam.class)
    public void login(final String phone) {
        User user=haskdornot(phone);
        if (user==null){
            return; //
        }


    }

    public User haskdornot(String phone) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("bizCode", "1");
        String str = new OkHttpEngin().get(BaseUrl.iscustomerUrl + phone, params, getCommonHeaders());
        JsonObject object = new JsonParser().parse(str).getAsJsonObject();  //�ַ���תjson
        JsonObject data = object.get("data").getAsJsonObject();
        User user = new Gson().fromJson(data, User.class);
        return user;
    }


    //  ��ȡ���������ID
    public void opportunityEmployee(final String phone) {
        String str = new OkHttpEngin().get(BaseUrl.opportunityEmployeeUrl + "1", null, getCommonHeaders());
        JsonObject object = new JsonParser().parse(str).getAsJsonObject();
        JsonArray data = object.get("data").getAsJsonArray();
        ArrayList<User> users = new Gson().fromJson(data, new TypeToken<ArrayList<User>>() {
        }.getType());  //������������
        String employeeId = users.get(0).getEmployeeId();
        createOpportunity(phone, employeeId);
    }

    //    �½�����
    public void createOpportunity(String phone, String employeeId) {
        final JsonObject object = new JsonObject();
        object.addProperty("bizCode", "1");
        object.addProperty("expectedBuyTimeCode", "4");
        object.addProperty("followUserId", employeeId);
        object.addProperty("genderCode", "F");
        object.addProperty("lastName", "zhang");
        object.addProperty("nextFollowTime", "1609486763113");
        object.addProperty("phone", phone);
        object.addProperty("priorityLevelCode", "C");
        object.addProperty("privacyLevelCode", "02");
        JsonObject object1 = new JsonObject();
        object1.addProperty("brandCode", "BMW");
        object1.addProperty("serialCode", "3");
        object.addProperty("customerTypeCode", "01");
        object.add("preferModel", object1);

        new OkHttpEngin().postJson(BaseUrl.createOpportunityUrl, object.toString(), getCommonHeaders(), new HttpCallBack() {
            @Override
            public void onSuccess(String str) {
                JsonObject jsonObject = new JsonParser().parse(str).getAsJsonObject();
                JsonObject data = jsonObject.get("data").getAsJsonObject();
                User user = new Gson().fromJson(data, User.class);
                String opportunityId = user.getId();
                opportunityDetail(opportunityId);
            }

            @Override
            public void onFail(String str) {
                System.out.print("this is faile" + str);
            }
        });
    }

    //    �鿴��������
    public void opportunityDetail(final String opportunityId) {
        new OkHttpEngin().get(BaseUrl.opportunityDetailUrl + opportunityId, null, getCommonHeaders(), new HttpCallBack() {
            @Override
            public void onSuccess(String str) {
//                System.out.println("This is "+str);
                opportuintyFollow(opportunityId);
            }
        });
    }

    //    �������
    public void opportuintyFollow(final String opportunityId) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("content", "���ǽӿڲ�������");
        jsonObject.addProperty("followTime", "1606912578717");// ��ȡ��ǰʱ���
        jsonObject.addProperty("followTypeCode", "1");
        jsonObject.addProperty("nextFollowTime", "1607517378952");//������ʱ���
        jsonObject.addProperty("priorityLevelCode", "A");
        jsonObject.addProperty("reachedCode", "1");
        jsonObject.addProperty("resultCode", "04");
        new OkHttpEngin().postJson(BaseUrl.opportunityFollow + opportunityId + "/follow", jsonObject.toString(), getCommonHeaders(), new HttpCallBack() {
            @Override
            public void onSuccess(String str) {
                System.out.println(str);
            }
        });
    }

    //  ����༭
    public void opportunityEdit() {

    }
}


