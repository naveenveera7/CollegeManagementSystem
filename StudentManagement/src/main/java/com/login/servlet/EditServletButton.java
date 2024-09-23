package com.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/editurl")
public class EditServletButton extends HttpServlet {
    private static final String query = "update STUDENTDATA set SNAME=?,SMAIL=?,SMOBILE=?, SBRANCH=?, SGROUP=?, SYEAR=? where id=?";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //get the id of record
        String id = req.getParameter("id");
        //get the edit data we want to edit
        String sname = req.getParameter("name");
        String smail = req.getParameter("email");
        String smobile = req.getParameter("contact");
        String sbranch = req.getParameter("branch");
        String sgroup = req.getParameter("group");
        String syear = req.getParameter("year");
        //LOAD jdbc driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }
        //generate the connection
        try (Connection con = DriverManager.getConnection("jdbc:mysql:///login", "root", "Naveen.12"); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, sname);
            ps.setString(2, smail);
            ps.setString(3, smobile);
            ps.setString(4, sbranch);
            ps.setString(5, sgroup);
            ps.setString(6, syear);
            ps.setString(7, id);
            int count = ps.executeUpdate();
            
            if (count == 1) {
                pw.println("<h2>Record is Edited Successfully</h2>");
            } else {
                pw.println("<h2>Record is not Edited Successfully</h2>");
            }
        } catch (SQLException se) {
            se.printStackTrace();
            pw.println("<h1>" + se.getMessage() + "</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h1>" + e.getMessage() + "</h2>");
        }
        pw.println("<a href='index2.jsp'>Home</a>");
        pw.println("<br>");
        pw.println("<a href='studentList'>Student List</a>");

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}