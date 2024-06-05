/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

/**
 *
 * @author demon
 */
import java.io.*;
import java.util.*;

public class CLibros {
    
        private String autor;
        private String editorial;
        private String nombre;
        private float precio;
        
        public CLibros(){
        }

    public CLibros(String autor, String editorial, String nombre, float precio) {
        this.autor = autor;
        this.editorial = editorial;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
        
        
    //un metodo para agregar los datos del libro
    public void aceptarDatos(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingresa el nombre del libro: ");
        nombre = entrada.nextLine();
        
        System.out.println("Ingresa el nombre del autor: ");
        autor = entrada.nextLine();
        
        System.out.println("Ingresa la editorial: ");
        editorial = entrada.nextLine();
        
        System.out.println("Ingresa el precio: ");
        precio = entrada.nextFloat();
    }
    
}
