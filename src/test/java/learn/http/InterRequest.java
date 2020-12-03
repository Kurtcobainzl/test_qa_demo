package learn.http;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import learn.base.BaseTime;
import learn.base.BaseUrl;
import learn.bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static learn.base.BaseConfig.getCommonHeaders;

public class InterRequest {
//    查看是否有客档
    public static User haskdornot(String phone) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("bizCode", "1");
        String str = new OkHttpEngin().get(BaseUrl.iscustomerUrl + phone, params, getCommonHeaders());
        JsonObject object = new JsonParser().parse(str).getAsJsonObject();  //字符串转json
        JsonObject data = object.get("data").getAsJsonObject();
        User user = new Gson().fromJson(data, User.class);
        return user;
    }
    //  获取机会归属人ID
    public static String getOpportunityId(){
        String str = new OkHttpEngin().get(BaseUrl.opportunityEmployeeUrl + "1", null, getCommonHeaders());
        JsonObject object = new JsonParser().parse(str).getAsJsonObject();
        JsonArray data = object.get("data").getAsJsonArray();
        ArrayList<User> users = new Gson().fromJson(data, new TypeToken<ArrayList<User>>() {}.getType());  //解析对象数组
        String employeeId = users.get(0).getEmployeeId();
        return employeeId;
    }

    //    新建机会
    public static String getcreateOpportunity(String phone, String employeeId) {
        final JsonObject object = new JsonObject();
        object.addProperty("bizCode", "1");
        object.addProperty("expectedBuyTimeCode", "4");
        object.addProperty("followUserId", employeeId);
        object.addProperty("genderCode", "F");
        object.addProperty("lastName", "zhang");
        object.addProperty("nextFollowTime", BaseTime.DAY*2);
        object.addProperty("phone", phone);
        object.addProperty("priorityLevelCode", "C");
        object.addProperty("privacyLevelCode", "02");
        JsonObject object1 = new JsonObject();
        object1.addProperty("brandCode", "BMW");
        object1.addProperty("serialCode", "3");
        object.addProperty("customerTypeCode", "01");
        object.add("preferModel", object1);

        String postData =  new OkHttpEngin().postJson(BaseUrl.createOpportunityUrl, object.toString(), getCommonHeaders());
        JsonObject jsonObject = new JsonParser().parse(postData).getAsJsonObject();
        JsonObject data = jsonObject.get("data").getAsJsonObject();
        User user = new Gson().fromJson(data, User.class);
        String opportunityId = user.getId();
        return opportunityId;
    }
    //    查看机会详情
    public static String opportunityDetail(String opportunityId) {
        String getoppDe = new OkHttpEngin().get(BaseUrl.opportunityDetailUrl + opportunityId, null, getCommonHeaders());
        JsonObject jsonObject = new JsonParser().parse(getoppDe).getAsJsonObject();
        JsonObject data = jsonObject.get("data").getAsJsonObject();
        User user = new Gson().fromJson(data,User.class);
        String opporId = user.getId();
        return opporId;
    }

    //    机会跟进
    public void getopportuintyFollow(final String opportunityId) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("content", "这是接口测试内容");
        jsonObject.addProperty("followTime", BaseTime.DAY);
        jsonObject.addProperty("followTypeCode", "1");
        jsonObject.addProperty("nextFollowTime", BaseTime.DAY*3);
        jsonObject.addProperty("priorityLevelCode", "A");
        jsonObject.addProperty("reachedCode", "1");
        jsonObject.addProperty("resultCode", "04");
        String getfollow = new OkHttpEngin().postJson(BaseUrl.opportunityFollow + opportunityId + "/follow", jsonObject.toString(), getCommonHeaders());
//        return getFollow;
    }
}
