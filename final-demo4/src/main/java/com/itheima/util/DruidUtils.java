package com.itheima.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {
    //1.定义静态成员变量DataSource
    private static DataSource dataSource;
    //2.静态加载Druid里的资源存入dataSource
    static {
        Properties prop = new Properties();
        try {
            //寻找配置文件
            InputStream is=DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            //加载druid配置
            prop.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            dataSource=DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //3.获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    //4.释放资源
    public static  void close(PreparedStatement preparedStatement,Connection connection) throws SQLException {
            close(null,preparedStatement,connection);

    }
    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        if(preparedStatement!=null)
        {
            preparedStatement.close();
        }
        if(resultSet!=null)
        {
            resultSet.close();
        }
        if(connection!=null)
        {
            connection.close();
        }


    }
}


