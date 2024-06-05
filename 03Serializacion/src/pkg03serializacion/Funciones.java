/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg03serializacion;

/**
 *
 * @author demon
 */

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Funciones {
    
    //definimos las variables y objetos
    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
    String rep = "si";
    String nombre = "";
    int edad, numempleado, bol;
    
    //aplicamos polimorfismo a un objeto
    Persona profesor = new Docente();
    Persona estudiante = new Alumno();
    
    void menu(){
        //ciclo infinito
        while(true){
            //definri si entra en el menu
            while(rep.equalsIgnoreCase("si")){
                try{
                String var = JOptionPane.showInputDialog(
                        "Ingresa la opcion deseada : \n"
                      + "1.- Registrar nuevo Profesor\n"
                      + "2.- Registrar nuevo Alumno\n"
                      + "3.- Consultar Alumno\n"
                      + "4.- Salir\n");
                if(var == null){
                    System.exit(0);
                }
                
                int opcion = Integer.parseInt(var);
                
                switch (opcion) {
                    case 1:
                        //metodo para pedir datos
                        pedirDatosDocente();
                        //aplicamos el constructor de la clase
                        profesor = new Docente(numempleado, nombre, edad);
                        //guardo
                        guardarProfesor();
                        
                        break;
                    case 2:
                        //metodo para pedir datos
                        pedirDatosAlumno();
                        //aplicamos el constructor de la clase
                        estudiante = new Alumno(bol, nombre, edad);
                        //guardo
                        guardarAlumno();
                        
                        break;
                    case 3:
                        //metodo para leer
                        leerAlumno();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
                rep = JOptionPane.showInputDialog("Desea Repetir?");
            }catch(Exception e){
                    System.out.println("Error : " + e.getMessage());
            }
            }
        }
    }

    private void pedirDatosDocente() {
        numempleado = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingresa el numero de empleado"));
        nombre = JOptionPane.showInputDialog(
                "Ingresa el nombre del empleado");
        edad = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingresa la edad del empleado"));
    }

    private void guardarProfesor() throws Exception {
        //primero agregamos a la lista de persona
        listaPersonas.add(profesor);
        //creo un metodo para guardarlo en el archivo
        guardar();
    }

    private void pedirDatosAlumno() {
        bol = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingresa la boleta del alumno"));
        nombre = JOptionPane.showInputDialog(
                "Ingresa el nombre del alumno");
        edad = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingresa la edad del alumno"));
    }

    private void guardarAlumno() throws Exception{
        //primero agregamos a la lista de persona
        listaPersonas.add(estudiante);
        //creo un metodo para guardarlo en el archivo
        guardar();
    }
    //son los encargados de la serializacion el archivo de lectura y de escritura
    private void leerAlumno() throws Exception{
        ///el archivo ya existe, entonces hay que abrirlo
        FileInputStream archivo = new FileInputStream("archivo.bat");
        //como estoy guardando una lista de objetos tenemos que crear un buffer de lectura o escritura
        ObjectInputStream entrada = new ObjectInputStream(archivo);
        //primero tenemos que transformar la lectura de los objetos en 
        //el objecto correcto
        listaPersonas = (ArrayList)entrada.readObject();
        
        //tenemos que recorrer la lista
        for(int i = 0; i < listaPersonas.size(); i++){
            //recorro al objeto
            Alumno obj = (Alumno)listaPersonas.get(i);
            //ya que obtuve el primer objeto ahora lo muestro
            JOptionPane.showMessageDialog(null,
                    "Numero de Alumno en la Lista : " + (i+1) + "\n"
                  + "Boleta del Alumno : " + obj.getBoleta() + "\n"
                  + "Nombre del Alumno : " + obj.getNombre()+ "\n"
                  + "Edad del Alumno : " + obj.getEdad()+ "\n"
                  + "Tipo de Objeto : " + obj.tipoPersona() + "\n");
        }
    }

    private void guardar() throws Exception{
        //debemos crear el archivo donde se guardan los elementos
        FileOutputStream archivo = new FileOutputStream("archivo.bat");
        //tenemos que definir que vamos a guardar, en este son objetos
        ObjectOutputStream salida = new ObjectOutputStream(archivo);
        
        //empiezo a escribir en el archivo mis objetos
        salida.writeObject(listaPersonas);
        salida.close();
    }
}
