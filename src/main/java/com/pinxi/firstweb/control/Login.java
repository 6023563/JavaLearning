package com.pinxi.firstweb.control;

import com.pinxi.firstweb.entity.User;
import com.pinxi.firstweb.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.function.Supplier;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //       request.setCharacterEncoding("uft-8");
//        String username = new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8") ;
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        System.out.println(username);

        User user = new User(username, pwd);
        UserServiceImpl userService = new UserServiceImpl();
        User u = userService.checkUser(user);

        System.out.println(u);
        response.setCharacterEncoding("UTF-8");
        if(u!=null){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("failure");
        }
        String method = request.getMethod();
        System.out.println(method);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL.toString());
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        String protocol = request.getProtocol();
        System.out.println(protocol);
        String scheme = request.getScheme();
        System.out.println(scheme);


        System.out.println(request.getLocalName() + request.getLocalAddr() + request.getLocalPort());
        System.out.println(request.getRemoteHost() + request.getRemoteAddr() + request.getRemotePort() + request.getRemoteUser());

        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String element = parameterNames.nextElement();
            System.out.println(element + ":" +request.getParameter(element));
        }

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String element = headerNames.nextElement();
            System.out.println(element + ":" + request.getHeader(element));
        }

        //response


        System.out.println(response.getStatus());
        System.out.println(response.getContentType());
        System.out.println(response.getCharacterEncoding());


        response.setHeader("name","hdj");
        response.addHeader("sex","woman");
        response.addHeader("sex","man");
        response.addHeader("sex","middle");
//        response.setContentLength(18);
//        response.setDateHeader();


//        response.sendError(405,"not found");
        Collection<String> headerNames1 = response.getHeaderNames();
        for (String str:
             headerNames1) {
            System.out.println(str);
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
