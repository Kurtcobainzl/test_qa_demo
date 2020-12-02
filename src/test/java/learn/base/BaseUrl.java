package learn.base;

/**
 * 接口中没有变量只有常量 所以默认前缀都是 public static final
* 接口中只有抽象方法，抽象方法只定义不实现
* */
public interface BaseUrl {
    String  BdcBaseUrl = "https://dmoapi-demo.lingyue-digital.com/lingyue-platform-dmo-bdc-service/";
    String iscustomerUrl =BdcBaseUrl+ "customer/detail/"; // 查看当前手机号是否有客档
    String createOpportunityUrl = BdcBaseUrl+"opportunity/add";//创建机会接口
    String opportunityEmployeeUrl = BdcBaseUrl+"base/employee/list/";//查询机会归属人接口
    String opportunityDetailUrl = BdcBaseUrl+"opportunity/detail/";//查询机会详情接口
    String opportunityFollow = BdcBaseUrl+"opportunity/";//机会跟进接口

}
