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
    //    机会查询是否有客档
    @Test(description = "获取短信验证码", priority = 1, dataProvider = "getPhones", dataProviderClass = TestParam.class)
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
        JsonObject object = new JsonParser().parse(str).getAsJsonObject();  //字符串转json
        JsonObject data = object.get("data").getAsJsonObject();
        User user = new Gson().fromJson(data, User.class);
        return user;
    }


    //  获取机会归属人ID
    public void opportunityEmployee(final String phone) {
        String str = new OkHttpEngin().get(BaseUrl.opportunityEmployeeUrl + "1", null, getCommonHeaders());
        JsonObject object = new JsonParser().parse(str).getAsJsonObject();
        JsonArray data = object.get("data").getAsJsonArray();
        ArrayList<User> users = new Gson().fromJson(data, new TypeToken<ArrayList<User>>() {
        }.getType());  //解析对象数组
        String employeeId = users.get(0).getEmployeeId();
        createOpportunity(phone, employeeId);
    }

    //    新建机会
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

    //    查看机会详情
    public void opportunityDetail(final String opportunityId) {
        new OkHttpEngin().get(BaseUrl.opportunityDetailUrl + opportunityId, null, getCommonHeaders(), new HttpCallBack() {
            @Override
            public void onSuccess(String str) {
//                System.out.println("This is "+str);
                opportuintyFollow(opportunityId);
            }
        });
    }

    //    机会跟进
    public void opportuintyFollow(final String opportunityId) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("content", "这是接口测试内容");
        jsonObject.addProperty("followTime", "1606912578717");// 获取当前时间戳
        jsonObject.addProperty("followTypeCode", "1");
        jsonObject.addProperty("nextFollowTime", "1607517378952");//三天后的时间戳
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

    //  机会编辑
    public void opportunityEdit() {

    }
}


