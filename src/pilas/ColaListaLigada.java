package pilas;

public class ColaListaLigada<T> {

    private Lista<T> lista = new Lista<T>();

    public void push(T dato) {
        lista.insertaInicio(dato);
    }

    public T pop() throws Exception {
        try {
            return lista.obtenerUltimoElemento();
        } catch (Exception ex) {
            throw new Exception("La pila está vacía");
        }
    }

    public T peek() throws Exception {
        try {
            return lista.obtenerUltimoElementoSinEliminar();
        } catch (Exception ex) {
            throw new Exception("La pila está vacía");
        }
    }

    public boolean vacia() {
        return lista.getInicio() == null;
    }

    public String toString() {
        String resultado = "";
        Nodo<T> aux = lista.invertir().getInicio();
        while (aux != null) {
            resultado = resultado + aux.getInfo().toString();
            aux = aux.getLiga();
        }
        return resultado;
    }
}
