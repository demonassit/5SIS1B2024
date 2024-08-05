/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajerooxxo;

/**
 *
 * @author demon
 */
public class Cajera {
    
    private String nombrecajera;
    
    public Cajera(){
    
    }

    public Cajera(String nombrecajera) {
        this.nombrecajera = nombrecajera;
    }

    public String getNombrecajera() {
        return nombrecajera;
    }

    public void setNombrecajera(String nombrecajera) {
        this.nombrecajera = nombrecajera;
    }
    
    //debe de procesar las compras del cliente
    public void procesarCompra(
            Cliente cliente, long timeStamp){
        System.out.println("La cajera " + this.nombrecajera 
                + "Comienza a cobrar las compras del cliente "
        + cliente.getNombre() + "En el tiempo : " 
                + (System.currentTimeMillis() - timeStamp)/1000);
        
        //iniciamos con los productos
        for(int i = 0; 
                i < cliente.getCarrocompras().length; i++ ){
            this.esperarXsegundo(cliente.getCarrocompras()[i]);
            System.out.println("Procesando compra del producto: "
                    +(i+1) + "-> Tiempo : " 
                    + (System.currentTimeMillis() - timeStamp)/1000 + "segundos");
        }
        
        //una vez que termine el proceso debemos cerrar la compra
        System.out.println("La cajera " + this.nombrecajera 
        + "HA TEMRINADO DE PROCESAR LA COMPRA DEL CLIENTE : " 
        + cliente.getNombre() + "En el tiempo : " 
        + (System.currentTimeMillis() - timeStamp)/1000 + "segundos");
    }

    private void esperarXsegundo(int carrocompra) {
        //aqui es donde se debe de meter el hilo 
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println("Mensaje: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
    
}
