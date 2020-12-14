package learn.base;

/**
 * 接口中没有变量只有常量 所以默认前缀都是 public static final
* 接口中只有抽象方法，抽象方法只定义不实现
* */
public interface BaseUrl {
    String  BdcBaseUrl = "https://dmoapi-int.lingyue-digital.com/lingyue-platform-dmo-bdc-service";
    String VisitBaseUrl ="https://dmoapi-int.lingyue-digital.com/lingyue-platform-dmo-visit-service";
    String iscustomerUrl =BdcBaseUrl+ "/customer/detail/"; // 查看当前手机号是否有客档
    String createOpportunityUrl = BdcBaseUrl+"/opportunity/add";//创建机会接口
    String opportunityEmployeeUrl = BdcBaseUrl+"/base/employee/list/";//查询机会归属人接口
    String opportunityDetailUrl = BdcBaseUrl+"/opportunity/detail/";//查询机会详情接口
    String opportunityFollow = BdcBaseUrl+"/opportunity/";//机会跟进接口
    String oppDetailUrl = VisitBaseUrl+"/visit/opp/detail/";//通过手机号查询是否有客档
    String addVisitUrl = VisitBaseUrl+"/visit/add";//新增展厅客流
    String distruVisitUrl = VisitBaseUrl+"/visit/distribute";//分配客流
    String pcColumnsUrl = VisitBaseUrl+"/dealership_customer/pc/columns";//查询展厅规则设置pc
    String padListVisitUrl = VisitBaseUrl+"/visit/front/list";//获取展厅客流列表pad
    String editVisitUrl = VisitBaseUrl+"/visit/edit/{id}";//编辑客流
    String startVisitUrl = VisitBaseUrl+"/visit/reception/start/{visitId}";//开始接待
    String mobilVisitUrl = VisitBaseUrl+"/visit/reception/confirm-mobile/{visitId}/{mobile}";//确认手机号
    String failVisitUrl = VisitBaseUrl+"/visit/reception/fail/{visitId}";//结束接待 客流无效
    String exitVisitUrl = VisitBaseUrl+"/visit/exit/{visitId}";//客流离店
    String frontVisitUrl = VisitBaseUrl+"/visit/logs/front/list";//展厅日志列表
    String saleListVisitUrl = VisitBaseUrl+"/visit/sales/list";// 展厅客流列表 pc
    String detailVisitUrl = VisitBaseUrl+"/visit/detail/{id}";//展厅客流详情
    String logsVisitUrl = VisitBaseUrl+"/visit/detail/{id}";// 日志导出
}
