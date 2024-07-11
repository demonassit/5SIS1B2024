/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author demon
 */
import java.sql.*;

public class Conexion {
    
    public static Connection getConection(){
        String url = "jdbc:mysql://localhost/registroestudiantes";
                    //controlador:motorbd:puerto//IP/nombreBD
        String username = "root";
        String password = "n0m3l0";
        
        //establezco mi conexion
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Conexion realizada con exito");
        
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se conecto a la BD");
        }
        return con;
    }
}
