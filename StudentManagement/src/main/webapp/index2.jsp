<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=session.getAttribute("name") %> Details</title>
<style>
body{
background-image:url("https://th.bing.com/th/id/OIP.KAeWBMqgA5qiZH9c83fBCwHaFE?rs=1&pid=ImgDetMain");
background-size:cover;
}
    table {
        width: 50%;
        border-collapse: collapse;
        margin: 20px auto;
        background-color:white;
        border-radius:5px;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
    }
    h2{
    color:white
    }
</style>
</head>
<body >
<h2>GoodMorning! </h2>
<table>
<tr><td><h3>Welcome <%= session.getAttribute("name")%></h2></td></tr>
<tr>
<td>Name: </td>
 <td><%= session.getAttribute("name")%></td>
 </tr>
 <tr>
 <td>ID: </td>
  <td><%= session.getAttribute("ID")%></td>
  </tr>
  <tr>
 <td>Payment Status: </td>
  <td><%= session.getAttribute("pay")%></td>
  </tr>
</table>
<button style='height:40px;width:120px;border-radius:6px'><a href="registration.jsp" style='text-decoration:none;font-weight:bold'>Register</a></button>
<button style='height:40px;width:120px;border-radius:6px'><a href="studentList" style='text-decoration:none;font-weight:bold;'>StudentList</a></button>
<button><a href="login.jsp">Logout</a></button>
</body>
</html>