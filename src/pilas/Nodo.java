package pilas;

public class Nodo<T> {

    Nodo(T dato) {
        this.info = dato;
        this.liga = null;
    }

    Nodo() {

    }

    private T info;
    private Nodo<T> liga;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getLiga() {
        return liga;
    }

    public void setLiga(Nodo<T> liga) {
        this.liga = liga;
    }

}
