package learn.base;

/**
 * �ӿ���û�б���ֻ�г��� ����Ĭ��ǰ׺���� public static final
* �ӿ���ֻ�г��󷽷������󷽷�ֻ���岻ʵ��
* */
public interface BaseUrl {
    String  BdcBaseUrl = "https://dmoapi-demo.lingyue-digital.com/lingyue-platform-dmo-bdc-service/";
    String iscustomerUrl =BdcBaseUrl+ "customer/detail/"; // �鿴��ǰ�ֻ����Ƿ��п͵�
    String createOpportunityUrl = BdcBaseUrl+"opportunity/add";//��������ӿ�
    String opportunityEmployeeUrl = BdcBaseUrl+"base/employee/list/";//��ѯ��������˽ӿ�
    String opportunityDetailUrl = BdcBaseUrl+"opportunity/detail/";//��ѯ��������ӿ�
    String opportunityFollow = BdcBaseUrl+"opportunity/";//��������ӿ�

}
