package learn.testcase;

import learn.bean.User;
import learn.http.InterRequest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class VisitControlleer {
//    查询是否有客档
    @Test(description = "获取短信验证码", priority = 1, dataProvider = "getPhones", dataProviderClass = TestParam.class)
    public void iscustomer(final String phone){
        User user =  InterRequest.iskednag(phone);
        if (user != null){
            System.out.print("当前已有客档，读取客档数据"+user);
        }else {
            pcColu();
        }
    }
//    查询备注必填字段
    public void pcColu(){
        ArrayList<User> user = InterRequest.visitIsTrue();
        for(User i : user){
            ArrayList mustWrite = new ArrayList();
            System.out.println(i); // 下面打印出来的数据就是
//            System.out.println(i.getrequiredStatusName());
//            System.out.println(i.getrequiredStatusName() instanceof Object);  //true

            if (i.getrequiredStatusName() == "是"){ //是个对象 不能判断为字符串 .toString不好使
                System.out.println("11"+i.getFiledName());

            }
        }

    }
    //    新建客流
//    分配客流

//    获取展厅客流列表
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
