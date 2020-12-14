package learn.http;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import learn.base.BaseTime;
import learn.base.BaseUrl;
import learn.bean.Test;
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
        System.out.println(str);
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
    public static String getopportuintyFollow(final String opportunityId) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("content", "这是接口测试内容");
        jsonObject.addProperty("followTime", BaseTime.DAY);
        jsonObject.addProperty("followTypeCode", "1");
        jsonObject.addProperty("nextFollowTime", BaseTime.DAY*3);
        jsonObject.addProperty("priorityLevelCode", "A");
        jsonObject.addProperty("reachedCode", "1");
        jsonObject.addProperty("resultCode", "04");
        String getfollow = new OkHttpEngin().postJson(BaseUrl.opportunityFollow + opportunityId + "/follow", jsonObject.toString(), getCommonHeaders());
        JsonObject jsonObj = new JsonParser().parse(getfollow).getAsJsonObject();
        JsonObject data = jsonObject.get("jsonObj").getAsJsonObject();
        User user  = new Gson().fromJson(data,User.class);
        String getId = user.getId();
        return getId;
    }

//    展厅客流
//    通过手机号查询是否有客档
    public static User iskednag(String phone){
        Map<String, Object> param= new HashMap<String, Object>();
        param.put("bizCode", "1");
        String getPhone= new OkHttpEngin().get(BaseUrl.oppDetailUrl  + phone, param, getCommonHeaders());
        JsonObject jsonObject = new JsonParser().parse(getPhone).getAsJsonObject();
        Test test = new Gson().fromJson(getPhone, Test.class);
        if (test.getData() != null){
            JsonObject data1 = jsonObject.get("data").getAsJsonObject();
            User iske = new Gson().fromJson(data1,User.class);
//            User.CustomeInfo cusId = iske.getCustomeInfo();
            return iske;
        }else {
            return null;
        }
    }
//    查询客流备注字段是否为必填
    public static ArrayList<User> visitIsTrue(){
        String pcColums = new OkHttpEngin().get(BaseUrl.pcColumnsUrl,null,getCommonHeaders());
        JsonObject jsonObject = new JsonParser().parse(pcColums).getAsJsonObject();
        JsonArray jsonArray = jsonObject.get("data").getAsJsonArray();
        ArrayList<User> users = new Gson().fromJson(jsonArray, new TypeToken<ArrayList<User>>() {}.getType());  //解析对象数组
        return users;
    }
//    新建展厅客流
    public static User.CustomeInfo addVisit(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("lastName","wang");
        jsonObject.addProperty("reasonsCode","1");
        jsonObject.addProperty("genderCode","M");
        String getAddata = new OkHttpEngin().postJson(BaseUrl.addVisitUrl,jsonObject.toString(),getCommonHeaders());
        JsonObject jsonObj = new JsonParser().parse(getAddata).getAsJsonObject();
        System.out.println(getAddata);
        JsonObject data = jsonObject.get("jsonObj").getAsJsonObject();
        User user = new Gson().fromJson(data,User.class);
        User.CustomeInfo addvissitId = user.getCustomeInfo();
        return addvissitId;
    }
//    分配客流  --weixiew
public void distribute(Integer userId,Integer visitId){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",userId);
        map.put("visitId",visitId);
        String getDisVisit = new OkHttpEngin().get(BaseUrl.distruVisitUrl, map,getCommonHeaders());
        JsonObject data = new JsonParser().parse(getDisVisit).getAsJsonObject();
        User userdata = new Gson().fromJson(data,User.class);
//
//        User.CustomeInfo addvissit= user.getCustomeInfo();
//        return addvissit;
}
//    获取展厅客流列表
public void listPc(Integer lastId,Integer pageSize){
    Map<String,Object> map = new HashMap<String, Object>();
    map.put("userId",lastId);
    map.put("visitId",pageSize);
    String getDisVisit = new OkHttpEngin().get(BaseUrl.distruVisitUrl, map,getCommonHeaders());
    JsonObject data = new JsonParser().parse(getDisVisit).getAsJsonObject();
    User userdata = new Gson().fromJson(data,User.class);
//
//        User.CustomeInfo addvissit= user.getCustomeInfo();
//        return addvissit;
}
//    编辑客流

//    开始接待
//    确认手机号
//    新建机会 已有方法
//    机会跟进  已有方法
//    结束接待
//   客流离店
//    展厅日志列表
//    展厅客流列表 pc
//    展厅客流详情
//    展厅客流编辑
//    日志导出
}
