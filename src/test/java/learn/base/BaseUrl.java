package learn.base;

/**
 * �ӿ���û�б���ֻ�г��� ����Ĭ��ǰ׺���� public static final
* �ӿ���ֻ�г��󷽷������󷽷�ֻ���岻ʵ��
* */
public interface BaseUrl {
    String  BdcBaseUrl = "https://dmoapi-int.lingyue-digital.com/lingyue-platform-dmo-bdc-service";
    String VisitBaseUrl ="https://dmoapi-int.lingyue-digital.com/lingyue-platform-dmo-visit-service";
    String iscustomerUrl =BdcBaseUrl+ "/customer/detail/"; // �鿴��ǰ�ֻ����Ƿ��п͵�
    String createOpportunityUrl = BdcBaseUrl+"/opportunity/add";//��������ӿ�
    String opportunityEmployeeUrl = BdcBaseUrl+"/base/employee/list/";//��ѯ��������˽ӿ�
    String opportunityDetailUrl = BdcBaseUrl+"/opportunity/detail/";//��ѯ��������ӿ�
    String opportunityFollow = BdcBaseUrl+"/opportunity/";//��������ӿ�
    String oppDetailUrl = VisitBaseUrl+"/visit/opp/detail/";//ͨ���ֻ��Ų�ѯ�Ƿ��п͵�
    String addVisitUrl = VisitBaseUrl+"/visit/add";//����չ������
    String distruVisitUrl = VisitBaseUrl+"/visit/distribute";//�������
    String pcColumnsUrl = VisitBaseUrl+"/dealership_customer/pc/columns";//��ѯչ����������pc
    String padListVisitUrl = VisitBaseUrl+"/visit/front/list";//��ȡչ�������б�pad
    String editVisitUrl = VisitBaseUrl+"/visit/edit/{id}";//�༭����
    String startVisitUrl = VisitBaseUrl+"/visit/reception/start/{visitId}";//��ʼ�Ӵ�
    String mobilVisitUrl = VisitBaseUrl+"/visit/reception/confirm-mobile/{visitId}/{mobile}";//ȷ���ֻ���
    String failVisitUrl = VisitBaseUrl+"/visit/reception/fail/{visitId}";//�����Ӵ� ������Ч
    String exitVisitUrl = VisitBaseUrl+"/visit/exit/{visitId}";//�������
    String frontVisitUrl = VisitBaseUrl+"/visit/logs/front/list";//չ����־�б�
    String saleListVisitUrl = VisitBaseUrl+"/visit/sales/list";// չ�������б� pc
    String detailVisitUrl = VisitBaseUrl+"/visit/detail/{id}";//չ����������
    String logsVisitUrl = VisitBaseUrl+"/visit/detail/{id}";// ��־����
}
