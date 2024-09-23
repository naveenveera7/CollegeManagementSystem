<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StdentDetails</title>
<style>
    table {
        width: 50%;
        border-collapse: collapse;
        margin: 20px auto;
        background-color:white;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
<h1 style="text-align: center; color:black: font-weight:bold"> Student Details</h1>
  <h2><%= session.getAttribute("name") %></h2>
  <a href="login.jsp">LogOut</a>
    <table>
        <tr>
            <th></th>
            <th></th>
        </tr>
        <tr>
            <td>RollNo</td>
            <td><%= session.getAttribute("id") %></td>
        </tr>
        
        <tr>
            <td>Name</td>
            <td><%= session.getAttribute("name") %></td>
        </tr>
        <tr>
            <td>Contact</td>
            <td><%= session.getAttribute("contact") %></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><%= session.getAttribute("email") %></td>
        </tr>
        <tr>
            <td>Branch</td>
            <td><%= session.getAttribute("branch") %></td>
        </tr>
        <tr>
            <td>Section</td>
            <td><%= session.getAttribute("group") %></td>
        </tr>
        <tr>
            <td>YearOfStudy</td>
            <td><%= session.getAttribute("year") %></td>
        </tr>
    </table>
</body>
</html>