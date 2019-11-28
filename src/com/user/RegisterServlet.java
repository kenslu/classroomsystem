package com.user;

import com.dao.Select;
import com.dao.UserInsert;
import com.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = utf-8");
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        String userPwd1 = req.getParameter("userPwd1");
        if(StringUtil.isNotEmpty(userName) && StringUtil.isNotEmpty(userPwd) && new Select().select(userName) == null && userPwd.equals(userPwd1)){
            if(new UserInsert().insert(userName,userPwd) > 0) {
                resp.sendRedirect(""+req.getContextPath()+"/successPage.jsp");
            } else {
                resp.sendRedirect(""+req.getContextPath()+"/errorPage.jsp");
            }
        } else {
            resp.sendRedirect(""+req.getContextPath()+"/errorPage.jsp");
        }
    }
}
