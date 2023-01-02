/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ua.edu.sumdu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Default", urlPatterns = "/", loadOnStartup = 1)
public class StudentAdd extends HttpServlet {

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
        PrintWriter pw = null;
        try{
            pw = response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace(pw);
            pw.print(ex.getMessage());
        }   
        
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            if(request.getParameter("name") != null && request.getParameter("surname") != null){
                PreparedStatement ps = conn.prepareStatement("INSERT INTO student (name, surname, age, email, group_, faculty) VALUES (?, ?, ?, ?, ?, ?)");
                
                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("surname"));
                ps.setInt(3, Integer.parseInt(request.getParameter("age")));
                ps.setString(4, request.getParameter("email"));
                ps.setString(5, request.getParameter("group"));
                ps.setString(6, request.getParameter("faculty"));
                ps.executeUpdate();
                response.sendRedirect("./");
            }
            
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM STUDENT");
            List<Student> students = new LinkedList<Student>();
            
            while(rs.next()){
                Student student = new Student(rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                students.add(student); 
            } 
            request.setAttribute("students", students);
            request.getRequestDispatcher("view.jsp").forward(request, response);
        }catch(SQLException ex){
            pw.print(ex.getMessage());
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException ex){
                    ex.getMessage();
                }
            }
        }
            
        }
}

