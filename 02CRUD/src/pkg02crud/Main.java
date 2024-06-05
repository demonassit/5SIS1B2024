/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg02crud;

/**
 *
 * @author demon
 */
import java.util.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner entrada = new Scanner(System.in);
        
        //tendria que meter un objeto del arraylist
        AccionesPersona controlador = new AccionesPersona();
        //menu
        
        System.out.println("Bienvenido a el registro de alumnos");
        System.out.println("Por favor elije una opcion");
        System.out.println("1.- Para consultar a todos los alumnos");
        System.out.println("2.- Para registrar uno nuevo");
        System.out.println("3.- Para editar sus datos");
        System.out.println("4.- Elminar un alumno");
        System.out.println("5.- Salir");
        
        int opcion = Integer.parseInt(entrada.nextLine());
        
        switch (opcion) {
            case 1:
                //genero mi instancia
                ArrayList<Persona> listaPersonas = controlador.listaPersonas;
                //vamos a imprimirlas
                for(Persona objeto : listaPersonas){
                    System.out.println("El id del estudiante : " 
                            + objeto.getId() 
                            + "El nombre es: " + objeto.getNombre()
                            + "Su edad es: " + objeto.getEdad());
                }
                
                break;
            case 2:
                System.out.println("Ingresa el identificador del alumno :");
                int idalumno = Integer.parseInt(entrada.nextLine());
                System.out.println("Ingresa el nombre del alumno :");
                String nombre = entrada.nextLine();
                System.out.println("Ingresa la edad del alumno :");
                int edad = Integer.parseInt(entrada.nextLine());
                
                //creo una nueva instancia
                Persona personaNueva = new Persona(idalumno, nombre, edad);
                //mando a llamar a mi controlador
                controlador.agregarPersona(personaNueva);
                break;
            case 3:
                System.out.println("ingresa el id del alumno que deseas editar");
                idalumno = Integer.parseInt(entrada.nextLine());
                //la busco
                Persona personaBuscar = controlador.buscarPersona(idalumno);
                
                System.out.println("La informacion del estudiante es :"
                        + "ID" + personaBuscar.getId() + "\n"
                        + "nombre" + personaBuscar.getNombre() + "\n"
                        + "edad" + personaBuscar.getEdad() + "\n");
                //agregar los nuevos datos
                System.out.println("Ingresa el nuevo nombre");
                String nuevonombre = entrada.nextLine();
                System.out.println("Ingresa la nueva edad");
                int nuevaedad = Integer.parseInt(entrada.nextLine());
                
                //los envio
                personaBuscar.setNombre(nuevonombre);
                personaBuscar.setEdad(nuevaedad);
                
                //lo actualizo
                controlador.actualizarPersona(personaBuscar);
                break;
            case 4:
                System.out.println("ingresa el id del alumno que se dar de baja");
                 idalumno = Integer.parseInt(entrada.nextLine());
                 //objeto para eliminar
                 Persona personaEliminar = controlador.buscarPersona(idalumno);
                 
                 controlador.elminarPersona(personaEliminar);
                 break;
                
            default:
                System.out.println("Opcion no viable");
        }
    }
    
}
