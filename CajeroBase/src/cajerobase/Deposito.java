/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajerobase;

/**
 *
 * @author demon
 */

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import java.util.*;


public class Deposito implements Runnable{
    
    List<String> dinero;
    
    public Deposito(List<String> dinero){
        this.dinero = dinero;
    }

    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(2000);
                synchronized(dinero){
                    SuperClaseSaldo.saldo = 
                            SuperClaseSaldo.saldo + 100;
                    dinero.notify();
                    System.out.println("Se ha depositado 100");
                }
            }catch(InterruptedException e){
                System.out.println(Deposito.class.getName());    
            }
        }
    }
    
    
    
}
