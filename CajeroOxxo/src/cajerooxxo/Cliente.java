/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajerooxxo;

/**
 *
 * @author demon
 */
public class Cliente {
    
    private String nombre;
    private int[] carrocompras;
    
    public Cliente(){
    
    }

    public Cliente(String nombre, int[] carrocompras) {
        this.nombre = nombre;
        this.carrocompras = carrocompras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getCarrocompras() {
        return carrocompras;
    }

    public void setCarrocompras(int[] carrocompras) {
        this.carrocompras = carrocompras;
    }
    
    
}
