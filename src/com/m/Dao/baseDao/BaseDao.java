package com.m.Dao.baseDao;

import java.sql.*;


public abstract class BaseDao {
    public BaseDao() {
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection conn = null;

    protected Connection getConnection() throws SQLException {
        //2.获取与数据库的连接
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String password = "1";
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    protected void closeConnection() {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
