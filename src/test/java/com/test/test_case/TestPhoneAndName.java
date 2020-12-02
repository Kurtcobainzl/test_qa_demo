package com.test.test_case;

import com.test.data_provider.TestParam;
import com.test.listener.TestReport;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//@Listeners({TestReport.class})
public class TestPhoneAndName {
    TestPhoneAndName(){
        System.out.print("123123");
    }

    static {
        System.out.println("sdf jskdf ");
    }

//    @Test(description = "获取xls文件中的数据并打印", priority = 1, dataProvider = "getPickUpInfos", dataProviderClass = TestParam.class)

@Test
public void printPhoneAndName(String name, String phone) throws Exception {
//        System.out.println(name + "\t联系方式\t" + phone);
//        try {
//            Long.parseLong(phone);
//            new TestLogin().getSms(phone);
//        } catch (Exception e) {
//            Assert.assertTrue(false);
//        }

    }
}
