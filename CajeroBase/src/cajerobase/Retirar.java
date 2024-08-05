/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajerobase;

import java.util.List;

/**
 *
 * @author demon
 */
public class Retirar implements Runnable{
    
     List<String> dinero;
     
     public Retirar(List<String> dinero){
        this.dinero = dinero;
    }

    @Override
    public void run() {
        synchronized(dinero){
            if(SuperClaseSaldo.saldo == 0.00){
                try{
                    System.out.println("Hola en el cajero " 
                            + Thread.currentThread().getName() 
                            + " no hay dinero llegale ");
                    dinero.wait();
                }catch(InterruptedException e){
                    System.out.println(Deposito.class.getName());
                }
            }else{
                SuperClaseSaldo.saldo = 
                            SuperClaseSaldo.saldo - 100;
                    dinero.notify();
            }
        }
    }
    
}
