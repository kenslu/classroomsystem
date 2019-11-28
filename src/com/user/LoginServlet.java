package com.user;

import com.dao.UserSelect;
import com.model.User;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = utf-8");
        req.setCharacterEncoding("utf-8");

        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        String login = req.getParameter("login");
        String register = req.getParameter("register");

        if(login != null) { //判断如果点击的是登录按钮
            User user = new UserSelect().select(userName,userPwd);
            if(user != null) {

                if(user.getUserPower() == 0) { //管理员界面
                    resp.sendRedirect(""+req.getContextPath()+"/superPage.jsp"); //重定向，两次请求
                }else { //用户界面
                    resp.sendRedirect(""+req.getContextPath()+"/userPage.jsp");
                }
            }else {
                resp.sendRedirect(""+req.getContextPath()+"/errorPage.jsp");
            }
        }
        if(register != null) {
            resp.sendRedirect(""+req.getContextPath()+"/registerPage.jsp");
        }
    }
}
