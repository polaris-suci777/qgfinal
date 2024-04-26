package com.itheima.dao;
import com.itheima.pojo.Manager;
import com.itheima.util.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManagerDao {
    public Manager createmanager(Manager manager) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "INSERT INTO manager (id, name, password) VALUES (null,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, manager.getName());
            stmt.setString(2, manager.getPassword());
            stmt.executeUpdate();
            // 假设插入成功，返回插入的教师对象（在实际应用中，您可能需要从数据库重新检索以获取完整或更新的数据）  
            return manager;
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // 在发生异常时返回null  
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();;;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
