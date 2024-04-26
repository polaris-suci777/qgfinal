package com.itheima.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC 工具类
 */
public class JDBCUtil {
    private static String url="jdbc:mysql://localhost:3306/db1?characterEncoding=UTF-8";
    private static String username="root";
    private static String password="memorystar@123";

    private  static String driver="com.mysql.jdbc.Driver";

    /**
     * 文件读取，只会执行一次，使用静态代码块
     */
//    static {
//        //读取文件，获取值
//        try {
//            //1.创建Properties集合类
//            Properties pro = new Properties();
//            //获取src路径下的文件--->ClassLoader类加载器
//            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
//            URL resource = classLoader.getResource("jdbc.properties");;
//            String path = resource.getPath();
//            //2.加载文件
//            pro.load(new FileReader(path));
//            //3获取数据
//            url = pro.getProperty("url");
//            username = pro.getProperty("username");
//            password = pro.getProperty("password");
//            driver = pro.getProperty("driver");
//            //4.注册驱动
//            Class.forName(driver);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    /**
     * 释放资源
     * @param rs
     * @param st
     * @param conn
     */
    public static void close(ResultSet rs, Statement st,Connection conn) throws SQLException {
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            conn.close();;;
        }
    }
}

