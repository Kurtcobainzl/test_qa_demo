package learn.testcase;

import org.testng.annotations.DataProvider;

public class TestParam {
    @DataProvider
    public static Object[][] getPhones(){
        Object[][] objects = {{"13383175411"}};
        return objects;
    }
}
