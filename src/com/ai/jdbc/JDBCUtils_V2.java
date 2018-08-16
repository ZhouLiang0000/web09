package com.ai.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 提供获取连接和释放资源的方法
 */
public class JDBCUtils_V2 {
    private static String driver = null;
    private static String url = null;
    private static String userName = null;
    private static String userPassword = null;

    //静态代码块加载配置文件信息
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        driver = bundle.getString("driver");
        url = bundle.getString("url");
        userName = bundle.getString("username");
        userPassword = bundle.getString("password");
    }

    /**
     * 获取连接方法
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源的方法
     */
    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
