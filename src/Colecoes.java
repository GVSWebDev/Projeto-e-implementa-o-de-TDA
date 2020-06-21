public interface Colecoes<T> {
    /**
     *
     * @return
     */
    int qtdeElems();

    /**
     *
     * @return
     */
    default boolean isVazia() {
        return qtdeElems() == 0;
    }
}
