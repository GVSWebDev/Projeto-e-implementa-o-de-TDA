public interface Fila<T> extends Colecoes<T> {
    void enfileirar(T obj);
    T desenfileirar();
    T olharPrimeiro();
}
