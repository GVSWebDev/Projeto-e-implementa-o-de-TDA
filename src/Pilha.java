public interface Pilha<T> extends Colecoes<T> {
    /**
     *Template para criação do método que empilha um elemento no topo da pilha
     * @param obj
     */
    void empilhar(T obj);

    /**
     *Template para criação do método que desempilha o elemento no topo da pilha;.
     * @return
     */
    T desempilhar();

    /**
     *Template para criação do método que retorna o elemento no topo da pilha.
     * @return
     */
    T olharTopo();
}
