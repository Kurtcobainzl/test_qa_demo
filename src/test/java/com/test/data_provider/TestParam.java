package com.test.data_provider;


import com.test.bean.Teacher;
import com.test.db.MySqlDB;
import com.test.db.SqlHelper;
import com.test.utils.ExcelUtil;
import com.test.utils.PropertiesUtil;
import org.testng.annotations.DataProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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

        String[][] args = new ExcelUtil("demo03.csv", "case001").readExcel();
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
    public static void main(String[] arg1s) throws SQLException {


        //测试mysql数据库
        System.out.println("查询所有teacher    开始（1）");
        new SqlHelper().getAllTeachers();

        /**
         * 上下两端执行结果完全一致。
         */

//        System.out.println("查询所有teacher    开始（2）");
//        ArrayList<Teacher> infos = new ArrayList<Teacher>();
//        MySqlDB.getConn();
//        ResultSet resultSet = MySqlDB.getResultSet("SELECT * FROM  Teacher");
//        while (resultSet.next()) {
//            Teacher teacher = new Teacher();
//            teacher.setId(resultSet.getInt(1));
//            teacher.setName(resultSet.getString(2));
//            teacher.setAge(resultSet.getInt(3));
//            teacher.setSubject(resultSet.getString(4));
//            System.out.println(teacher);
//            infos.add(teacher);
//        }
//        MySqlDB.close();  //先取出值，后关闭sql.否则会抛出异常。


//        System.out.println("测试PropertiesUtil    开始");
        //测试PropertiesUtil类
//        String string = PropertiesUtil.getValue("spring.datasource.username");
//        System.out.println(string);

//        System.out.println("测试csv文件读取    开始");
        //测试 csv文件读取
//        String[][] args = null;
//        try {
//            args = new ExcelUtil("demo03.csv", "case001").readExcel();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(args.length);
//        for (String[] a : args) {
//            for (String b : a) {
//                System.out.print("\t" + b);
//            }
//            System.out.println();
//        }
    }

}
