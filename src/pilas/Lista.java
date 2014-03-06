package pilas;

public class Lista<T> {

    private Nodo<T> inicio;

    public String generaStringComoLista() {
        String resultado = "";
        if (getInicio() == null) {
            return "Lista vacía";
        } else {
            Nodo<T> aux = inicio;
            while (aux != null) {
                resultado = resultado + aux.getInfo().toString() + "=>";
                aux = aux.getLiga();
            }
        }
        return resultado + "nil";
    }

    public Nodo<T> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    public void insertaInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setLiga(inicio);
        inicio = nuevo;

    }

    public void insertaFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        Nodo<T> aux = inicio;
        if (inicio == null) {
            inicio = nuevo;
        } else {
            while (aux.getLiga() != null) {
                aux = aux.getLiga();
            }
            aux.setLiga(nuevo);

        }
    }

    public void insertaAntesDato(T dato, T datoInicial) throws Excepcion {
        if (inicio == null) {
            throw new Excepcion("La lista está vacía.");
        }
        Nodo<T> actual = inicio;
        Nodo<T> anterior = null;
        boolean band = false;
        while (!actual.getInfo().equals(datoInicial) && !band) {
            if (actual.getLiga() != null) {
                anterior = actual;
                actual = actual.getLiga();
            } else {
                band = true;
            }

        }
        if (!band) {
            Nodo<T> nodo = new Nodo<>(dato);
            if (actual == inicio) {
                nodo.setLiga(inicio);
                inicio = nodo;
            } else {
                anterior.setLiga(nodo);
                nodo.setLiga(actual);
            }

        } else {
            throw new Excepcion("El nodo dado como referencia no está en la lista");
        }
    }

    public void insertaDespuesDato(T dato, T datoInicial) throws Excepcion {
        if (inicio == null) {
            throw new Excepcion("La lista está vacía.");
        }
        Nodo<T> actual = inicio;
        boolean band = false;
        while (!actual.getInfo().equals(datoInicial) && !band) {
            if (actual.getLiga() != null) {
                actual = actual.getLiga();
            } else {
                band = true;
            }

        }
        if (!band) {
            Nodo<T> nodo = new Nodo<>(dato);
            nodo.setLiga(actual.getLiga());
            actual.setLiga(nodo);
        } else {
            throw new Excepcion("El nodo dado como referencia no está en la lista");
        }
    }

    public T obtenerPrimerElemento() throws Excepcion {
        T dato = null;
        if (inicio != null) {
            dato = inicio.getInfo();
            inicio = inicio.getLiga();
        } else {
            throw new Excepcion("La lista está vacía");
        }
        return dato;
    }

    public T obtenerPrimerElementoSinEliminar() throws Excepcion {
        T dato = null;
        if (inicio != null) {
            dato = inicio.getInfo();

        } else {
            throw new Excepcion("La lista está vacía");
        }
        return dato;
    }

    public T obtenerUltimoElemento() {
        Nodo<T> aux = inicio;
        Nodo<T> anterior = null;
        T resultado = null;
        if (inicio.getLiga() == null) {
            resultado = inicio.getInfo();
            inicio = null;
        } else {
            while (aux.getLiga() != null) {
                anterior = aux;
                aux = aux.getLiga();
            }
            resultado = aux.getInfo();
            anterior.setLiga(null);
        }
        return resultado;
    }

    public T obtenerUltimoElementoSinEliminar() {
        Nodo<T> aux = inicio;
        Nodo<T> anterior = null;
        T resultado = null;
        if (inicio.getLiga() == null) {
            resultado = inicio.getInfo();

        } else {
            while (aux.getLiga() != null) {
                anterior = aux;
                aux = aux.getLiga();
            }
            resultado = aux.getInfo();

        }
        return resultado;
    }

    public void borrarLista() {
        inicio = null;
    }

    public void borrarPrimerElemento() {
        if (inicio != null) {
            inicio = inicio.getLiga();
        }
    }

    public void borrarUltimoElemento() {
        Nodo<T> aux = inicio;
        Nodo<T> anterior = null;
        if (inicio.getLiga() == null) {
            inicio = null;
        } else {
            while (aux.getLiga() != null) {
                anterior = aux;
                aux = aux.getLiga();
            }
            anterior.setLiga(null);
        }
    }

    public Lista<T> invertir() {
        Lista<T> resultado = new Lista<>();
        Nodo<T> aux = inicio;
        while (aux != null) {
            resultado.insertaInicio(aux.getInfo());
            aux = aux.getLiga();
        }
        return resultado;
    }

    public String toString() {
        String resultado = "{";
        if (getInicio() == null) {
            return "Lista vacía";
        } else {
            Nodo<T> aux = inicio;
            while (aux != null) {
                resultado = resultado + aux.getInfo().toString() + ",";
                aux = aux.getLiga();
            }
        }
        return resultado.substring(0, resultado.length() - 1) + "}";

    }

}
