public interface Fila<T> extends Colecoes<T> {

    /**
     * Template para criação do método de enfileiração.
     * @param obj
     */
    void enfileirar(T obj);

    /**
     * Template para criação do método de desenfileiração.
     * @return
     */
    T desenfileirar();

    /**
     * Template para criação do método que retorna o primeiro elemento da fila.
     * @return
     */
    T olharPrimeiro();
}
