package com.login.project;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {

        String id = req.getParameter("username");
        String spwd = req.getParameter("password");
        
        
        HttpSession session = req.getSession();
        RequestDispatcher dispatcher = null;
        Connection con = null;
        PreparedStatement pst = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Naveen.12");
            pst = con.prepareStatement("select * from studentdata where id=? and spwd=?");
            
            pst.setString(1, id);
            pst.setString(2, spwd);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
            	session.setAttribute("id", rs.getString("id"));
            	session.setAttribute("name", rs.getString("sname"));
            	session.setAttribute("contact", rs.getString("smobile"));
            	session.setAttribute("email", rs.getString("smail"));
            	session.setAttribute("group", rs.getString("sgroup"));
            	session.setAttribute("branch", rs.getString("sbranch"));
            	session.setAttribute("year", rs.getString("syear"));
            	
                dispatcher = req.getRequestDispatcher("index.jsp");
            } else {
                req.setAttribute("status", "failed");
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
