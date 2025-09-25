/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio02;


public class Producto implements Comparable<Producto>{
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    public Producto() {
    }
    
    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(String codigo) {
        this.codigo = codigo;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public String getCodigo(){
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

@Override
public String toString() {
    return String.format("Cód: %s | Nombre: %s | Precio: S/ %,.2f | Stock: %s ",
                         codigo, nombre, precio, stock);
}
@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto productoAComparar = (Producto) obj;
        return this.codigo.equalsIgnoreCase(productoAComparar.codigo);
    }

    @Override
    public int compareTo(Producto o) {
        return this.nombre.compareTo(o.nombre);
    }
}
