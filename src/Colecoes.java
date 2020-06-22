public interface Colecoes<T> {
    /**
     *Template para criação do método que retorna a quantidade de elementos.
     * @return
     */
    int qtdeElems();

    /**
     *Template para criação do método que verifica se a quantidade de elementos da fila, lista ou pilha é igual a zero.
     * @return
     */
    default boolean isVazia() {
        return qtdeElems() == 0;
    }
}
