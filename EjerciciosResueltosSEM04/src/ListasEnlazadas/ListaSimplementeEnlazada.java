/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasEnlazadas;

import java.util.function.Predicate;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

@FunctionalInterface
interface ObjectToRowConverter<T> {

    Object[] toRow(T object);
}

public class ListaSimplementeEnlazada<T extends Comparable<T>> {

    Nodo<T> L;

    public ListaSimplementeEnlazada() {
        this.L = null;
    }

    public boolean esVacia() {
        return L == null;
    }

    public void insertarAlInicio(T valor) {
        Nodo<T> nuevo = new Nodo<T>(valor);
        nuevo.setSgte(L);
        L = nuevo;
    }

    public void insetarAlFinal(T valor) {
        Nodo<T> nuevo = new Nodo<T>(valor);
        if (L == null) {
            L = nuevo;
        } else {
            Nodo<T> p = L;
            while (p.getSgte() != null) {
                p = p.getSgte();
            }
            p.setSgte(nuevo);
        }

    }

    public int contar() {
        int contador = 0;
        Nodo<T> p = L;
        while (p != null) {
            contador++;
            p = p.getSgte();
        }
        return contador;
    }

    public Nodo<T> buscar(T datoBuscado) {
        Nodo<T> p = L;
        while (p != null) {
            if (p.getInfo().equals(datoBuscado)) {
                return p;
            }
            p =p.getSgte();
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


    public boolean modificar(T datoAntiguo, T datoNuevo) {
        Nodo<T> p = L;

        while (p != null) {
            if (p.getInfo().equals(datoAntiguo)) {
                p.setInfo(datoNuevo);
                return true;
            }
            p = p.getSgte();
        }

        return false;
    }

    public void mostrarPares(DefaultListModel<Integer> modeloPares) {
        Nodo<T> p = L;

        modeloPares.removeAllElements();

        while (p != null) {

            if (p.getInfo() instanceof Integer numero) {

                if (numero % 2 == 0) {
                    modeloPares.addElement(numero);
                }
            }
            p = p.getSgte();

        }
    }

    public void ordenar() {
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
       public void mostrarConFiltro(DefaultListModel<T> modelo, Predicate<T> filtro) {
        modelo.removeAllElements();
        Nodo<T> p = L;
        while (p != null) {
            if (filtro.test(p.getInfo())) {
                modelo.addElement(p.getInfo());
            }
            p = p.getSgte();
        }
    }
    public boolean eliminar(T datoAEliminar) {
        if (L == null) {
            return false;
        }

        if (L.getInfo().equals(datoAEliminar)) {
            L = L.getSgte();
            return true;
        }

        Nodo<T> ant = L;
        Nodo<T> p = L.getSgte();

        while (p != null) {
            if (p.getInfo().equals(datoAEliminar)) {
                ant.setSgte(p.getSgte());
                return true;
            }
            ant = p;
            p = p.getSgte();
        }

        return false;
    }
    
}
