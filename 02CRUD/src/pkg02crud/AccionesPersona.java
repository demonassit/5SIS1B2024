/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg02crud;

/**
 *
 * @author demon
 */

import java.util.*;

public class AccionesPersona {
    
    //vamos a realizar un crud
    
    public ArrayList<Persona> listaPersonas 
            = new ArrayList<Persona>();
    
    //necesitmaos un metodo para listas a las personas
    public ArrayList<Persona> mostrarPersonas(){
        return listaPersonas;
    }
    
    //registrar  a las personas
    public void agregarPersona(Persona p ){
        listaPersonas.add(p);
    }
    
    //necesito buscar una persona, 
    public Persona buscarPersona(int id){
        //instacnia de una persona
        Persona encontrada = new Persona();
        for(Persona p : listaPersonas){
            if(id == p.getId()){
                //que si la encontro
                encontrada = p;
            }else{
                System.out.println("Persona no encontrada");
            }
        }
        return encontrada;
    }
    
    //actualizar una persona
    public void actualizarPersona(Persona actualizar){
        Persona actualizada = 
                buscarPersona(actualizar.getId());
        listaPersonas.remove(actualizada);
        listaPersonas.add(actualizada);
    }
    
    //eliminar una persona
    public void elminarPersona(Persona eliminar){
        listaPersonas.remove(eliminar);
    }
}
