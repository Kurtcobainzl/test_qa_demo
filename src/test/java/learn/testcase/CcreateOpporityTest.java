package learn.testcase;

import learn.bean.User;
import learn.http.InterRequest;
import org.testng.annotations.Test;

public class CcreateOpporityTest {

    //机会查询是否有客档
    @Test(description = "获取短信验证码", priority = 1, dataProvider = "getPhones", dataProviderClass = TestParam.class)
    public void login(final String phone) {
        User user = InterRequest.haskdornot(phone);
        if (user.getId() == null) {
            opportunityEmployee( phone);
        }
        opportunityDetail(user.getId());
    }
    //  获取机会归属人ID
    public void opportunityEmployee(final String phone) {
        String employeeId = InterRequest.getOpportunityId();
        createOpportunity(phone, employeeId);
    }
    // 新建机会
    public void createOpportunity(String phone, String employeeId) {
        String opportunityId = InterRequest.getcreateOpportunity(phone,employeeId);
        opportunityDetail(opportunityId);
    }
    // 查看机会详情
    public void opportunityDetail(final String opportunityId) {
        String opportunityDetail = InterRequest.opportunityDetail(opportunityId );
        if (opportunityDetail !=""){
            opportuintyFollow(opportunityId);
        }
        System.out.println("查看机会详情失败");
    }

    // 机会跟进
    public void opportuintyFollow(final String opportunityId) {
        String followId = InterRequest.getopportuintyFollow(opportunityId);
        if (followId !=""){
            System.out.println("机会跟进成功");
        }
    }

    //  机会编辑
    public void opportunityEdit() {

    }
}


