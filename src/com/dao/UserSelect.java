package com.dao;

import com.model.User;
import com.util.CloseUtil;
import com.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 该类可以实现，已知用户名和密码，对数据库进行查找，如果找到返回该用户所有信息，否则返回空
 */
public class UserSelect {
    public User select(String userName,String userPwd) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = dbUtil.getConn();
            //创建Sql命令
            String sql = "select * from user where userName = ? and userPwd = ?";
            //创建Sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1,userName);
            ps.setString(2,userPwd);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setUserName(rs.getString("userName"));
                user.setUserPwd(rs.getString("userPwd"));
                user.setUserPower(rs.getInt("userPower"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new CloseUtil().close(conn);
        }
        return user;
    }
}
