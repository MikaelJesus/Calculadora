package pilas;

public class PilaListaLigada<T> {

    private Lista<T> lista = new Lista<T>();

    public void push(T dato) {
        lista.insertaInicio(dato);
    }

    public T pop() throws Exception {
        try {
            return lista.obtenerPrimerElemento();
        } catch (Exception ex) {
            throw new Exception("La pila está vacía");
        }
    }

    public T peek() throws Exception {
        try {
            return lista.obtenerPrimerElementoSinEliminar();
        } catch (Exception ex) {
            throw new Exception("La pila está vacía");
        }
    }

    public boolean vacia() {
        return lista.getInicio() == null;
    }
}
