package com.login.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {

        String fid = req.getParameter("FacultyID");
        String fpwd = req.getParameter("password");
        
        HttpSession session = req.getSession();
        RequestDispatcher dispatcher = null;
        Connection con = null;
        PreparedStatement pst = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Naveen.12");
            pst = con.prepareStatement("select * from flogin where fid=? and fpwd=?");
            
            pst.setString(1, fid);
            pst.setString(2, fpwd);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
            	session.setAttribute("name", rs.getString("ftaff"));
            	session.setAttribute("ID", rs.getString("fid"));
                dispatcher = req.getRequestDispatcher("index2.jsp");
            } else {
                req.setAttribute("status2", "failed");
                dispatcher = req.getRequestDispatcher("login.jsp");
            }
            dispatcher.forward(req, res);
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
