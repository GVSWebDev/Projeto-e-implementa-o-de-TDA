public interface Pilha<T> extends Colecoes<T> {
    /**
     *
     * @param obj
     */
    void empilhar(T obj);

    /**
     *
     * @return
     */
    T desempilhar();

    /**
     *
     * @return
     */
    T olharTopo();
}
