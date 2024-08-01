/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg06hilos;

/**
 *
 * @author demon
 */

//un hilo es un proceso que se lleva a cabo en el sistema
//los hilos permiten ejecutar procesos independientes
//que se ejecutan como elementos de un objeto
//cada hilo puede tener su propia serie de operaciones
//cada hilo puede mandar a llamar a otros hilos

public class ProcesoHilo extends Thread {
    
    //constructor
    public ProcesoHilo(){
        
    }
    
    public ProcesoHilo(String nombreHilo){
        super(nombreHilo);
    }
    
    //para correr el hilo tiempo
    int num_int;
    
    //vamos a ejecutar un hilo
    public void run(){
        //necesitamos definir el tiempo de ejecucion
        for(int i = 0; i <= num_int; i++){
            System.out.println(" + " + this.getName() );
        }
        System.out.println(" ");
        
    }
    
    public void valorDeCondicion(int valor){
        this.num_int = valor;
    }
    
    
}
