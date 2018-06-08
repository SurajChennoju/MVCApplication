package com.javawebtutor.controller;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.javawebtutor.model.User;
import com.javawebtutor.service.LoginService;
 
 
public class LoginServlet extends HttpServlet 
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
 
     String username = request.getParameter("username");   
     String password = request.getParameter("password");
     LoginService loginService = new LoginService();
   //  System.out.println(username);
   //  System.out.println(password);
     boolean result = loginService.authenticateUser(username, password);
     User user = loginService.getUserByFirstName(username);
     if(result == true)
     {
    	 //System.out.println("result is true");
         request.getSession().setAttribute("user", user);   
         //System.out.println(user);
         response.sendRedirect("home.jsp");
     }
     else
     {
         response.sendRedirect("error.jsp");
     }
}
 
}