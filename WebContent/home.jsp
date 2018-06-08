<%@page import="java.util.List"%>
<%@page import="com.javawebtutor.service.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.javawebtutor.model.User"%>
<%@page import="com.javawebtutor.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link rel="stylesheet" type="text/css" href="css/style.css"/>
     <title>Result Page</title>
</head>
<body>
<center>
     <div id="container">
         <h1>Result Page</h1>
             <b>This is Sample Result Page</b><br/>
             <%=new Date()%></br>
             <%
                 User user = (User) session.getAttribute("user");
             %>     
             <b>Welcome <%= user.getFirstName() + " " + user.getLastName()%></b>     
             <br/>
             <a href="logout.jsp">Logout</a>
         </p>
 
         <table>
             <thead>
                 <tr>
<!--                      <th>User ID</th> -->
                     <th>Product Name</th>
                     <th>Product Description</th>
                     <th>Product Price</th>
                   <th>Action</th>                

                 </tr>
             </thead>
             <tbody>
                 <%
                     LoginService loginService = new LoginService();
                     List<Product> list = loginService.getListOfProducts();
                     for (Product p : list) 
                     {
                 %>
                 <tr>
                     <td><%=p.getName()%></td>
                     <td><%=p.getDescription()%></td>
                     <td><%=p.getPrice()%></td>
                     <td><button type="button" onclick="">Add</button></td>
<!--                      <a id='edit_anchor' class="success btn btn-success" -->
<%-- 						href=${pageContext.request.contextPath}/editStudentDetails?email=<%=user.getEmail() %>>View/Edit</a> --%>
                 </tr>
                 <%}%>
             <tbody>
         </table>    
         <br/>
     </div>
    </center>
</body>
</html>