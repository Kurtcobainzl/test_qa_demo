package com.test.db;

import com.test.bean.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 对MySqlDB进行业务封装。把数据处理代码放在这里执行
 */
public class SqlHelper {


    /**
     * 获取数据库中所有teacher信息。
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Teacher> getAllTeachers() throws SQLException {
        ArrayList<Teacher> infos = new ArrayList<Teacher>();
        MySqlDB.getConn();
        ResultSet resultSet = MySqlDB.getResultSet("SELECT * FROM  Teacher");
        while (resultSet.next()) {
            Teacher teacher = new Teacher();
            teacher.setId(resultSet.getInt(1));
            teacher.setName(resultSet.getString(2));
            teacher.setAge(resultSet.getInt(3));
            teacher.setSubject(resultSet.getString(4));
            System.out.println(teacher);
            infos.add(teacher);
        }
        MySqlDB.close();  //先取出值，后关闭sql.否则会抛出异常。
        return infos;
    }


}
