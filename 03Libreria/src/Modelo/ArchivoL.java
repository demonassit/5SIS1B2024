/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author demon
 */
import java.io.*;
import java.util.*;

import Controladores.*;


public class ArchivoL implements Serializable{
    
    //vamos a crear un objeto mediante el gual pueda guardar 
    //los libros o revistas
    
    ArrayList<CLibros> listadelibros = new ArrayList<CLibros>();
    
    //neceisto un metodo para poder leer el archivo
    public ArrayList<CLibros> leer(){
        //primero se crea el objeto de la lectura
        try{
            ObjectInputStream in = 
                new ObjectInputStream(
                        new FileInputStream("libro.txt"));
            listadelibros = (ArrayList<CLibros>)in.readObject();
            in.close();
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
            }
        return listadelibros;
        
    }
    
    
    //metodo para escribir
    void escribir(ArrayList<CLibros> listaserializada){
        try{
            //generando primero el archivo de salida
            FileOutputStream salida = new FileOutputStream("libro.txt");
            //genero la escritura de los objetos
            ObjectOutputStream salidaobjeto = new ObjectOutputStream(salida);
            
            //y ahora empiezo a escribir
            salidaobjeto.writeObject(listaserializada);
            
           
            
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
}
