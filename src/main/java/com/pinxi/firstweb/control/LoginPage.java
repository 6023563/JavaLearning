package com.pinxi.firstweb.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


public class LoginPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<html>");
        response.getWriter().write("<head>");
        response.getWriter().write("<title>");
        response.getWriter().write("MyFirstWeb");
        response.getWriter().write("</title>");
        response.getWriter().write("</head>");
        response.getWriter().write("<body>");
        response.getWriter().write("<form action='login' method='post'>");
        response.getWriter().write("登录名:<input type='text' name='username' value=''><br/>");
        response.getWriter().write("密码:<input type='password' name='pwd' value=''><br/>");
        response.getWriter().write("<input type='submit' value='submit'>");
        response.getWriter().write("</form>");
        response.getWriter().write("</body>");
        response.getWriter().write("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
