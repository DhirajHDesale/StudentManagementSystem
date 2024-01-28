/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.kiran;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dhira
 */
public class DisplayData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayData</title>"); 
               out.println("<style>");
out.println("table { border-collapse: collapse; margin-left: 350px; margin-top: 60px; }");
out.println("th,td { border: 1px solid black; padding: 8px; }");
out.println("</style>");
            out.println("</head>");
            
            out.println("<body>");
            out.println("<h1 style='text-align:center; margin-top: 200px; margin-left:60px;'>List of Students Registered</h1>");
          out.println("<table>");
        out.println("<tr><th>Id</th><th>Name</th><th>Phone</th><th>Email</th><th>Gender</th><th>Edit</th><th>Delete</th></tr>");
 
            
            
              try {
           Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","KiranPatil@2001");
    PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
    
   ResultSet rs = ps.executeQuery();

    while (rs.next()) {
out.println("<tr>");
out.println("<td> "+rs.getInt("id")+"</td>");
out.println("<td> "+rs.getString("name")+"</td>");
out.println("<td> "+rs.getString("phoneno")+"</td>");
out.println("<td> "+rs.getString("email")+"</td>");
out.println("<td> "+rs.getString("gender")+"</td>");
out.println("<td><button style=' background-color:green ; color:white;'><a href='EditData?id="+rs.getInt(1)+"'><span style='color:#fff; font-size:20px'>Edit</span></a></button></td>");
out.println("<td><button style='background-color:red; color:white;'><a href='DeleteData?id="+rs.getInt(1)+"'><span style='color:#fff; font-size:20px'>Delete</a></span></button></td>");
out.println("</tr>");
   
    }
con.close();

    
} catch (SQLException e) {
    e.printStackTrace(); // Log the exception or handle it appropriately
}   catch (ClassNotFoundException ex) {
                Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
            }    
              out.println("</table>");
              out.println("</body>");
            out.println("</html>");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
