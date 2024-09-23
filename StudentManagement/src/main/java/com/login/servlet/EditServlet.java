package com.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editScreen")
public class EditServlet extends HttpServlet {
    private static final String query = "SELECT SNAME,SMAIL,SMOBILE,SBRANCH,SGROUP,SYEAR FROM STUDENTDATA where id=?";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //get the id of record
        String id =req.getParameter("id");
        //LOAD jdbc driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }
        //generate the connection
        try (Connection con = DriverManager.getConnection("jdbc:mysql:///login", "root", "Naveen.12"); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            pw.println("<form action='editurl?id=" + id + "' method='post'>");
            pw.println("<table align='center'>");
            pw.println("<tr>");
            pw.println("<td>StudentName:</td>");
            pw.println("<td><input type='text' name='name' value='" + rs.getString(1) + "'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>Email:</td>");
            pw.println("<td><input type='text' name='email' value='" + rs.getString(2) + "'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>Contact:</td>");
            pw.println("<td><input type='text' name='contact' value='" + rs.getString(3) + "'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>Branch:</td>");
            pw.println("<td><input type='text' name='branch' value='" + rs.getString(4) + "'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>Section</td>");
            pw.println("<td><input type='text' name='group' value='" + rs.getString(5) + "'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>YearOfStudy:</td>");
            pw.println("<td><input type='text' name='year' value='" + rs.getString(6) + "'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td><input type='submit' value='Update'></td>");
            pw.println("<td><button><a href='studentList' style='text-decoration:none;'>Cancel</a></button></td>");
            pw.println("</tr>");
            pw.println("</table>");
            pw.println("</form>");
        } catch (SQLException se) {
            se.printStackTrace();
            pw.println("<h1>" + se.getMessage() + "</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h1>" + e.getMessage() + "</h2>");
        }
        pw.println("<a href='index2.jsp'>Home</a>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}