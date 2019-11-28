package com.room;

import com.dao.RoomDelete;
import com.dao.RoomInsert;
import com.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/superDelete")
public class SuperDelete extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = utf-8");
        req.setCharacterEncoding("utf-8");

        String roomName = req.getParameter("roomName");
        if(StringUtil.isNotEmpty(roomName)){
            if(new RoomDelete().delete(roomName) > 0) {
                resp.sendRedirect(""+req.getContextPath()+"/successPage.jsp");
            } else {
                resp.sendRedirect(""+req.getContextPath()+"/errorPage.jsp");
            }
        } else {
            resp.sendRedirect(""+req.getContextPath()+"/errorPage.jsp");
        }
    }
}
