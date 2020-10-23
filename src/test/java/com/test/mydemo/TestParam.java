package com.test.mydemo;


import org.testng.annotations.DataProvider;


/**
 * 制造数据。  与逻辑分离
 */
public class TestParam {

    @DataProvider
    public static Object[][] getPhones() {
        Object[][] objects = {{"13310333333"}, {"13310333334"}, {"13310333335"}, {"13310333336"}, {"13310333337"}};
        return objects;
    }


}
