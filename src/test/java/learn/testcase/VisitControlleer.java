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
            System.out.println(i); // �����ӡ���������ݾ���
//            System.out.println(i.getrequiredStatusName());
//            System.out.println(i.getrequiredStatusName() instanceof Object);  //true

            if (i.getrequiredStatusName() == "��"){ //�Ǹ����� �����ж�Ϊ�ַ��� .toString����ʹ
                System.out.println("11"+i.getFiledName());

            }
        }

    }
    //    �½�����
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
