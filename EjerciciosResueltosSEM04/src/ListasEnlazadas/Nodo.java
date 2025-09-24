/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasEnlazadas;

/**
 *
 * @author Sistemas
 */
public class Nodo<T> {
    private T info;
    private Nodo<T> sgte;
    
    public Nodo(T valor){
    this.info = valor;
    this.sgte = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getSgte() {
        return sgte;
    }

    public void setSgte(Nodo<T> sgte) {
        this.sgte = sgte;
    }
    
    
}
