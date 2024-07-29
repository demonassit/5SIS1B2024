<%-- 
    Document   : inicio
    Created on : 11 jul 2024, 8:12:32 a.m.
    Author     : demon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*;" %>
<%@page import="Modelo.Alumno" %>
<%@page import="Controlador.AccionesAlumno" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Alumnos</title>
    </head>
    <body>
        <h1>Lista de Alumnos de Extraordinarios</h1>
        <div class="container" >
            <table>
                <thead>
                    <tr>ID</tr>
                    <tr>Nombre</tr>
                    <tr>Apellidos</tr>
                    <tr>Edad</tr>
                    <tr>Correo</tr>
                </thead>
                <tbody>
                    <% 
                        //tenemos que crear la lista de alumnos
                        List<Alumno> listaalumnos = AccionesAlumno.getAllAlumnos();
                        for(Alumno alu:listaalumnos){
                    %>
                    <tr>
                        <td> <%=alu.getIdAlumno()%>    </td>
                        <td> <%=alu.getNombre()%>    </td>
                        <td> <%=alu.getApellido()%>    </td>
                        <td> <%=alu.getEdad()%>    </td>
                        <td> <%=alu.getCorreo()%>    </td>
                        <td> <a href="editaralumno.jsp?id=<%=alu.getIdAlumno()%>" >
                                <img src="">ICONOEditar</a>     </td>
                        <td> <a href="eliminaralumno?id=<%=alu.getIdAlumno()%>" >
                                ICONOEliminar</a>     </td>
                    </tr>    
                    
                    <%    }
                        %>
                </tbody>
            </table>
        </div>
    </body>
</html>
