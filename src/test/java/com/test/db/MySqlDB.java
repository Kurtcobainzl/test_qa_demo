package com.test.db;

import com.test.utils.PropertiesUtil;

import java.sql.*;

public class MySqlDB {
    //	url:路径,用户名, 密码
    public static String url = PropertiesUtil.getValue("spring.datasource.url");
    public static String user = PropertiesUtil.getValue("spring.datasource.username");
    public static String password = PropertiesUtil.getValue("spring.datasource.password");


    //	1 加载驱动
    static {
        try {
            Class.forName(PropertiesUtil.getValue("spring.datasource.driver-class-name"));
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static Statement stmt = null;
    private static Connection conn = null;

    //	2 获取连接
    public static Connection getConn() {
        try {
            conn = DriverManager.getConnection(url, user, password);

            // 测试成功与否
            if (conn != null) {
                System.out.println("连接成功");
                stmt = conn.createStatement();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }

    //	3 关闭数据库
    public static void close(Object o) {
        try {
            if (o instanceof Connection) {
                ((Connection) o).close();
            } else if (o instanceof Statement) {
                ((Statement) o).close();
            } else if (o instanceof ResultSet) {
                ((ResultSet) o).close();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void close() {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 执行插入、更新、删除sql  （写操作）
     *
     * @param sql
     * @return
     */
    public static int insert(String sql) {
        try {
            int num = stmt.executeUpdate(sql);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


    /**
     * 执行查询sql    （查操作）
     *
     * @param sql
     * @return
     */
    public static ResultSet getResultSet(String sql) {
        ResultSet ret = null;
        try {
            ret = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (ret == null) {
            throw new NullPointerException("获取结果集为空");
        }
        return ret;
    }


}
