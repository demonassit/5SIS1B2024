/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

/**
 *
 * @author demon
 */

import java.util.*;

public class CRevistas extends CLibros {
    
    private String tipo_revista;
    
    public CRevistas(){
    }

    public CRevistas(String tipo_revista) {
        this.tipo_revista = tipo_revista;
    }

    public CRevistas(String tipo_revista, String autor, String editorial, String nombre, float precio) {
        super(autor, editorial, nombre, precio);
        this.tipo_revista = tipo_revista;
    }

    public String getTipo_revista() {
        return tipo_revista;
    }

    public void setTipo_revista(String tipo_revista) {
        this.tipo_revista = tipo_revista;
    }
    
    public void AgregarRevista(){
        Scanner entrada = new Scanner(System.in);
        
        CLibros nuevolibro = new CLibros();
        
        nuevolibro.aceptarDatos();
        
        System.out.println("Ingresa el tipo de revista: ");
        tipo_revista = entrada.nextLine();
    }
}
