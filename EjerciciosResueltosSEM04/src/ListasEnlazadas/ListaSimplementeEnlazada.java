/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasEnlazadas;

import javax.swing.DefaultListModel;

/**
 *
 * @author Sistemas
 */
public class ListaSimplementeEnlazada<T extends Comparable<T>> {
    Nodo<T> L;
    public ListaSimplementeEnlazada(){
        this.L = null;
    }
    public boolean esVacia(){
        return L == null;
    }
    public void insertarAlInicio(T valor){
        Nodo<T> nuevo = new Nodo<T>(valor);
        nuevo.setSgte(L);
        L = nuevo;
    }
    public void insetarAlFinal(T valor){
        Nodo<T> nuevo = new Nodo<T>(valor);
        if(L==null)
            L = nuevo;
        else{
            Nodo<T> p = L;
            while(p.getSgte()!= null)
                p = p.getSgte();
        p.setSgte(nuevo);
        }
            
    }
    public int contar(){
        int contador = 0;
        Nodo<T> p = L;
        while(p !=null){
            contador++;
            p = p.getSgte();
        }
        return contador;
    }
    public Nodo<T> buscar(T datoBuscado){
        Nodo<T> p = L;
        while(p != null){
            if(p.getInfo().equals(datoBuscado))
                return p;
            p.getSgte();
        }
        return null;
    }
    public void mostrar(DefaultListModel<T> modelo) {
        Nodo<T> p = L;
        modelo.removeAllElements();
        while (p != null) {
            modelo.addElement(p.getInfo());
            p = p.getSgte();
        }
    }
    public void ordenar(){
        if (L == null || L.getSgte() == null) {
            return;
        }

        Nodo<T> p = L;
        while (p.getSgte() != null) {
            Nodo<T> q = p.getSgte();
            while (q != null) {
                if (p.getInfo().compareTo(q.getInfo()) > 0) {
                    T aux = p.getInfo();
                    p.setInfo(q.getInfo());
                    q.setInfo(aux);
                }
                q = q.getSgte();
            }
            p = p.getSgte();
        }
    }
}

