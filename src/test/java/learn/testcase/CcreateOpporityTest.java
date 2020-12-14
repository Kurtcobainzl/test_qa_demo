package learn.testcase;

import learn.bean.User;
import learn.http.InterRequest;
import org.testng.annotations.Test;

public class CcreateOpporityTest {

    //�����ѯ�Ƿ��п͵�
    @Test(description = "��ȡ������֤��", priority = 1, dataProvider = "getPhones", dataProviderClass = TestParam.class)
    public void login(final String phone) {
        User user = InterRequest.haskdornot(phone);
        if (user.getId() == null) {
            opportunityEmployee( phone);
        }
        opportunityDetail(user.getId());
    }
    //  ��ȡ���������ID
    public void opportunityEmployee(final String phone) {
        String employeeId = InterRequest.getOpportunityId();
        createOpportunity(phone, employeeId);
    }
    // �½�����
    public void createOpportunity(String phone, String employeeId) {
        String opportunityId = InterRequest.getcreateOpportunity(phone,employeeId);
        opportunityDetail(opportunityId);
    }
    // �鿴��������
    public void opportunityDetail(final String opportunityId) {
        String opportunityDetail = InterRequest.opportunityDetail(opportunityId );
        if (opportunityDetail !=""){
            opportuintyFollow(opportunityId);
        }
        System.out.println("�鿴��������ʧ��");
    }

    // �������
    public void opportuintyFollow(final String opportunityId) {
        String followId = InterRequest.getopportuintyFollow(opportunityId);
        if (followId !=""){
            System.out.println("��������ɹ�");
        }
    }

    //  ����༭
    public void opportunityEdit() {

    }
}


