package com.test.data_provider;


import com.test.utils.ExcelUtil;
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


    /**
     * 获取 demo01.xls 文件中的  case001   sheet表中的数据
     *
     * @return
     * @throws Exception
     */
    @DataProvider
    public static Object[][] getPickUpInfos() throws Exception {

        String[][] args = new ExcelUtil("demo02.xlsx", "case001").readExcel();
        System.out.println(args.length);
        for (String[] a : args) {
            for (String b : a) {
                System.out.print(b);
            }
            System.out.println();
        }

        return args;
    }


    //test
    public static void main(String[] arg1s) {
        String[][] args = new String[0][];
        try {
            args = new ExcelUtil("demo03.csv", "case001").readExcel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(args.length);
        for (String[] a : args) {
            for (String b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }

}
