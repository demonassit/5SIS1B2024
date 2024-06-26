/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 *
 * @author demon
 */
public class RegistrarEstudiante extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private Connection con;
    //es para establecer el objeto de conexion
    
    private Statement set;
    //este objeto es para poder definir las sentencias sql
    
    private ResultSet rs;
    //este objeto sirve para poder realizar las consultas
    
    public void init(ServletConfig scg) throws ServletException{
        //este es el constructor de un servlet, que nos sirve
        //para poder realizar la conexion con BD
        //necesitamos saber donde esta la BD
        String url = "jdbc:mysql:3306//localhost/registroestudiantes";
                    //controlador:motorbd:puerto//IP/nombreBD
        String username = "root";
        String password = "n0m3l0";
        
        try{
            //vamos a intentar conectarnos a la bd
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://localhost/registroalumnos";
            //obtenemos un objeto para realizar la conexion
            con = DriverManager.getConnection(url, username, password);
            //ejecuto la sentencia para su conexion
            set = con.createStatement();
            System.out.println("Se conecto a la BD");
        }catch(Exception e){
            System.out.println("No se conecto solo juguito contigo");
            System.out.println("Error : "+ e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //vamos a obtener cada uno de los parametros del formulario
            
            String nom, appat, apmat, correo;
            int edad;
            
            nom = request.getParameter("nombre");
            appat = request.getParameter("appat");
            apmat = request.getParameter("apmat");
            correo = request.getParameter("correo");
            
            edad = Integer.parseInt(request.getParameter("edad"));
            
            System.out.println(nom);
            System.out.println(appat);
            System.out.println(apmat);
            System.out.println(edad);
            System.out.println(correo);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro de Estudiante</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
                String querry = "insert into "
                        + "alumnos(nombre, apellido, edad, correo)"
                        + " values ('"+nom+"', '"+appat+ " " + apmat+"', "+edad+", '"+correo+"')";
                
                //debemos preparar la sentencia
                set.executeUpdate(querry);
                System.out.println("Registro exitoso");
            
            out.println("<h1>El estudiante ha sido Registrado</h1>");
            
            

            }catch(Exception e){
                System.out.println("Error : " + e.getMessage());
                System.out.println("No se registro");
                System.out.println("Localizacion: " + e.getStackTrace());
                out.println("<h1>Ha sucedido un problema contacte al admin</h1>");
            }
            out.println("<a href='index.html' >Regresar al Formulario</a>");
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
