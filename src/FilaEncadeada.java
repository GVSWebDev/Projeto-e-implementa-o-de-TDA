public class FilaEncadeada<T> implements Fila<T> {
    /**
     * Theta(1)
     * @param obj
     */
    @Override
    public void enfileirar(T obj) {
        No<T> enfileirado = new No<>(obj);
        if (ultimo != null) ultimo.encadear(enfileirado);
        else                primeiro = enfileirado;

        ultimo = enfileirado;
        qtdeElems++;
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public T desenfileirar() {
        No<T> desenfileirado = primeiro;
        primeiro = desenfileirado.desencadear().orElse(null);

        qtdeElems--;
        if (desenfileirado == ultimo) ultimo = null;
        return desenfileirado.getValor();
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public T olharPrimeiro() {
        return primeiro.getValor();
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public int qtdeElems() {
        return qtdeElems;
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public boolean isVazia() {
        return primeiro == null;
    }

    private No<T> primeiro;
    private No<T> ultimo;
    private int qtdeElems = 0;
}
