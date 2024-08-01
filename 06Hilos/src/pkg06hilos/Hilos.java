/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg06hilos;

/**
 *
 * @author demon
 */
public class Hilos {
    
    //clase principal
    public static void main(String[] args){
        System.out.println("Ejemplo de un hilo");
        
        ProcesoHilo hilo1 = new ProcesoHilo();
        ProcesoHilo hilo2 = new ProcesoHilo();
        ProcesoHilo hilo3 = new ProcesoHilo();
        
        hilo1.valorDeCondicion(5);
        hilo2.valorDeCondicion(2);
        hilo3.valorDeCondicion(8);
        //debemos inicializarlos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
    }
    
}
