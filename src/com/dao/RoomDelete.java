package com.dao;

import com.util.CloseUtil;
import com.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RoomDelete {
    public int delete(String roomName) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        try {
            conn = dbUtil.getConn();
            String sql = "delete from room where roomName=?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, roomName);
            return pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            new CloseUtil().close(conn);
        }
        return 0;
    }

    public int deleteNull(String roomName) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        try {
            conn = dbUtil.getConn();
            String sql = "delete from room where roomStart=0 and roomName=? ";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, roomName);
            return pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            new CloseUtil().close(conn);
        }
        return 0;
    }
}
