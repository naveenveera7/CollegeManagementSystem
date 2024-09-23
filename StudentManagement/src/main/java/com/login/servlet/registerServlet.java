package com.login.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class registerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // Added serialVersionUID

    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
    	
    	String id = req.getParameter("id");
        String sname = req.getParameter("name");
        String smail = req.getParameter("email");
        String spwd = req.getParameter("pass");
        String smobile = req.getParameter("contact");
        String sbranch = req.getParameter("branch");
        String sgroup = req.getParameter("group");
        String syear = req.getParameter("year");
        RequestDispatcher dispatcher = null;
        Connection con = null;
        PreparedStatement pst = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Naveen.12");
            pst = con.prepareStatement("insert into studentdata(id,sname, smail, spwd, smobile, sbranch, sgroup, syear) values(?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, id);
            pst.setString(2, sname);
            pst.setString(3, smail);
            pst.setString(4, spwd);
            pst.setString(5, smobile);
            pst.setString(6, sbranch);
            pst.setString(7, sgroup);
            pst.setString(8, syear);

            int rowCount = pst.executeUpdate();
            
            if (rowCount > 0) {
            	res.sendRedirect("index2.jsp");
            } else {
                req.setAttribute("status", "failed");
                dispatcher = req.getRequestDispatcher("registration.jsp");
                dispatcher.forward(req, res);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
