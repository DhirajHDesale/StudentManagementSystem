/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.kiran;

import com.mysql.cj.protocol.Resultset;
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
public class EditData extends HttpServlet {

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
             
            out.println("<title>Servlet EditData</title>");   
            out.println("<style>");
            
            out.println("table {margin-top:200px;margin-left:300px;");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
           
          
         
     
    
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","KiranPatil@2001");
    PreparedStatement ps = con.prepareStatement("select * from students where id=?");
        int id = Integer.parseInt(request.getParameter("id"));
    ps.setInt(1, id);
              ResultSet rs = ps.executeQuery();
              
              rs.next();
              
              out.println("<form action='UpdateData?id="+id+"' method='post'>");
               out.println("<table align>");
       out.println("<tr>");
         
        out.println("<td>Enter Name: </td><td><input type='text'  name='name' value='"+rs.getString(2)+"'> </td></tr>");
           out.println("<tr><td>Enter Phone:</td><td> <input type='text' name='phone' value='"+rs.getString(3)+"'> </td></tr>");
              out.println("<tr><td>Enter Email: </td><td><input type='email' name='email' value='"+rs.getString(4)+"'></td></tr>");
              
                 out.println("<td><input type='submit' value='edit'></td>");
                   out.println("<td><input type='reset' value='cancel'></td>");
                         out.println("</table>");    
                out.println("</form>");  
                
              
      
    
  ps.executeUpdate();

   
con.close();

    
} catch (SQLException e) {
    e.printStackTrace(); // Log the exception or handle it appropriately
}   catch (ClassNotFoundException ex) {
                Logger.getLogger(EditData.class.getName()).log(Level.SEVERE, null, ex);
            }  
     
           
             
           
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
