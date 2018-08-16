package com.ai.jdbc;

import java.sql.*;

/**
 * 提供获取连接和释放资源的方法
 */
public class JDBCUtils_V1 {
    private static String className = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/web09";
    private static String userName = "zhouliang";
    private static String userPassword = "zhouliang";

    /**
     * 获取连接方法
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(className);
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
