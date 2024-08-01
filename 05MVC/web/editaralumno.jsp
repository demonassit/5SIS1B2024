<%-- 
    Document   : editaralumno
    Created on : 31 jul 2024, 8:25:57 a.m.
    Author     : demon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Alumno, Controlador.AccionesAlumno" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Datos del Estudiante</title>
    </head>
    <body>
        <div class="container" >
            <form method="post" name="formulario" 
                  action="actualizarAlumno" >  
                <table border="2">
                    <%
                        int id = Integer.parseInt(request.getParameter("id"));
                        System.out.println(id);
                        
//hacemos una instancia para buscar al alumno por id
                    Alumno alu = AccionesAlumno.buscarAlumnoById(id);
                        %>
                        <tr>    
                            <td>  ID  </td>
                            <td>  <input type="hidden" name="id2"
                                   value="<%=alu.getIdAlumno()%>"      >  </td>
                        </tr>
                        <tr>    
                            <td>  Nombre  </td>
                            <td>  <input type="text" name="nombre2"
                                   value="<%=alu.getNombre()%>"      >  </td>
                        </tr>
                        <tr>    
                            <td>  Apellido  </td>
                            <td>  <input type="text" name="apellido2"
                                   value="<%=alu.getApellido()%>"      >  </td>
                        </tr>
                        <tr>    
                            <td>  Edad  </td>
                            <td>  <input type="text" name="edad2"
                                   value="<%=alu.getEdad()%>"      >  </td>
                        </tr>
                        <tr>    
                            <td>  Correo  </td>
                            <td>  <input type="text" name="correo2"
                                   value="<%=alu.getCorreo()%>"      >  </td>
                        </tr>
                        <tr>
                            <td colspan="2" > <input type="submit" 
                                                     value="Actualizar Datos">    
                            </td>
                        </tr>
                </table>
            </form>
        </div>
    </body>
</html>
