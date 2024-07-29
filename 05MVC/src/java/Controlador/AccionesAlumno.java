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
import Modelo.Alumno;
import java.util.*;

public class AccionesAlumno {
    
    //los comportamientos son: registrar, consultar, editar, buscar, eliminar
    
    public static int registrarAlumno(Alumno alu){
        int estatus = 0;
        
        try{
            //vamos intentar registrar un alumno
            //establezco mi conexion
            Connection con = Conexion.getConection();
            String q = "insert into alumnos(nombre, apellido, edad, correo) "
                    + "values (?,?,?,?)";
            //como no se que datos son los que voy a incorporar debo de preparar la sentencia
            PreparedStatement ps = con.prepareStatement(q);
            //incorporo los datos
            //para poderlos incorporar debo declarar la ruta de donde los voy a obtener
            ps.setString(1, alu.getNombre());
            ps.setString(2, alu.getApellido());
            ps.setInt(3, alu.getEdad());
            ps.setString(4, alu.getCorreo());
            //ejecuto la sentencia
            estatus = ps.executeUpdate();
            System.out.println("Alumno registrado a Extraordinario");
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se pudo registrar el alumno al extraordinario");
        }
        return estatus;
    }
    
    //necesito poder consultar toda la lista de alumnos
    public static List<Alumno> getAllAlumnos(){
        //una lista es un objeto de tipo ArrayList
        List<Alumno> listaalumnos = new ArrayList<Alumno>();
        
        try{
            //primero establezco la conexion
            Connection con = Conexion.getConection();
            //declaro mi querry
            String q = "select * from alumnos";
            //preparo mi sentencia
            PreparedStatement ps = con.prepareStatement(q);
            //voy a consultar la tabla
            ResultSet rs = ps.executeQuery();
            //debo recorrer la tabla para obtener cada uno de los registros
            while(rs.next()){
                //vamos a obtener los datos del alumno
                Alumno alu = new Alumno();
                alu.setIdalumno(rs.getInt(1));
                alu.setNombre(rs.getString(2));
                alu.setApellido(rs.getString(3));
                alu.setEdad(rs.getInt(4));
                alu.setCorreo(rs.getString(5));
                //los agrego a la lista
                listaalumnos.add(alu);
            }
            System.out.println("Se obtuvieron los alumnos");
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se pudo obtener la lista");
        }
        return listaalumnos;
    }
    
    public static Alumno buscarAlumnoById(int id){
        Alumno alu = new Alumno(); 
        try{
            //vamos a buscarlo
            Connection con = Conexion.getConection();
            String q = "select * from alumno where idalumno = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            //tengo que buscar el id denro de la tabla
            if(rs.next()){
                alu.setIdalumno(rs.getInt(1));
                alu.setNombre(rs.getString(2));
                alu.setApellido(rs.getString(3));
                alu.setEdad(rs.getInt(4));
                alu.setCorreo(rs.getString(5));
            }
            System.out.println("Se encontro al alumno");
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return alu;
    }
    
     public static int editarAlumno(Alumno alu){
        int estatus = 0;
        
        try{
            //vamos intentar registrar un alumno
            //establezco mi conexion
            Connection con = Conexion.getConection();
            String q = "update set nombre = ?, apellido = ?, edad = ?, correo ? where idalumno = ? ";
            //como no se que datos son los que voy a incorporar debo de preparar la sentencia
            PreparedStatement ps = con.prepareStatement(q);
            //incorporo los datos
            //para poderlos incorporar debo declarar la ruta de donde los voy a obtener
            ps.setString(1, alu.getNombre());
            ps.setString(2, alu.getApellido());
            ps.setInt(3, alu.getEdad());
            ps.setString(4, alu.getCorreo());
            ps.setInt(5, alu.getIdalumno());
            //ejecuto la sentencia
            estatus = ps.executeUpdate();
            System.out.println("Alumno para editar");
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se puedo atualizar");
        }
        return estatus;
    }
     
      public static int eliminarAlumno(int id){
        int estatus = 0;
        
        try{
            //vamos intentar registrar un alumno
            //establezco mi conexion
            Connection con = Conexion.getConection();
            String q = "delete from alumno where idalumno =?";
            //como no se que datos son los que voy a incorporar debo de preparar la sentencia
            PreparedStatement ps = con.prepareStatement(q);
            //incorporo los datos
            //para poderlos incorporar debo declarar la ruta de donde los voy a obtener
            
            ps.setInt(1, id);
            
            //ejecuto la sentencia
            estatus = ps.executeUpdate();
            System.out.println("Alumno eliminado");
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se pudo eliminar el alumno al extraordinario");
        }
        return estatus;
    }
    
}
