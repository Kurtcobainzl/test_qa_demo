package learn.testcase;

import learn.bean.User;
import learn.http.InterRequest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class VisitControlleer {
//    ��ѯ�Ƿ��п͵�
    @Test(description = "��ȡ������֤��", priority = 1, dataProvider = "getPhones", dataProviderClass = TestParam.class)
    public void iscustomer(final String phone){
        User user =  InterRequest.iskednag(phone);
        if (user != null){
            System.out.print("��ǰ���п͵�����ȡ�͵�����"+user);
        }else {
            pcColu();
        }
    }
//    ��ѯ��ע�����ֶ�
    public void pcColu(){
        ArrayList<User> user = InterRequest.visitIsTrue();
        for(User i : user){
            ArrayList mustWrite = new ArrayList();
            /**
             * ==
             * equals
             */
            if ("��".equals(i.getrequiredStatusName())){ //�ж��ַ��� ֵ�Ƿ����
                System.out.println(i.getFiledName());
//                addVisit();
            }
        }

    }
    //    �½�����
    public void addVisit(){
        User.CustomeInfo user = InterRequest.addVisit();

    }
//    �������

//    ��ȡչ�������б�
//    �༭����

//    ��ʼ�Ӵ�
//    ȷ���ֻ���
//    �½����� ���з���
//    �������  ���з���
//    �����Ӵ�
//   �������
//    չ����־�б�
//    չ�������б� pc
//    չ����������
//    չ�������༭
//    ��־����

}
