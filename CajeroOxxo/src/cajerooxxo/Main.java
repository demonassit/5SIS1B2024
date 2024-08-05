/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajerooxxo;

/**
 *
 * @author demon
 */
public class Main {
    
    public static void main(String[] args){
        //defino a los cleintes
        Cliente cliente1 = new Cliente(
                "Juanito", new int[]{2, 2,3,4, 5});
        Cliente cliente2 = new Cliente(
                "Juanita", new int[]{2, 12,13,7, 5});
        
        Cajera cajera1 = new Cajera("Luisa");
        Cajera cajera2 = new Cajera("Victor");
        
        //inicialiizo el tiempo
        long initialtime = System.currentTimeMillis();
        
        cajera1.procesarCompra(cliente1, initialtime);
        cajera2.procesarCompra(cliente2, initialtime);
    }
    
}
