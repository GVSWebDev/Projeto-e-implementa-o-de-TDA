public class FilaArranjada<T> implements Fila<T> {

    @SuppressWarnings("unchecked")
    public FilaArranjada(int capacidade) {
        fila = (T[]) new Object[capacidade];
    }
    public FilaArranjada() {
        this(CAPACIDADE_PADRAO);
    }

    /**
     * O(n), Omega(1)
     * @param obj
     */
    @Override
    public void enfileirar(T obj) {
        fila[ultimo] = obj;
        ultimo = ultimo + 1 >= fila.length ? 0 : ultimo+1;

        if (ultimo == primeiro) expandirFila();
    }

    /**
     * Theta(1)
     */
    @Override
    public T desenfileirar() {
        T desenfileirado = fila[primeiro];
        fila[primeiro] = null;
        primeiro = primeiro + 1 >= fila.length ? 0 : primeiro+1;

        return desenfileirado;
    }

    /**
     * Theta(1)
     */
    @Override
    public T olharPrimeiro() {
        return fila[primeiro];
    }

    /**
     * Theta(1)
     */
    @Override
    public int qtdeElems() {
        return primeiro < ultimo
                ? ultimo - primeiro
                : fila.length - (primeiro - ultimo);
    }

    /**
     * Theta(1)
     */
    @Override
    public boolean isVazia() {
        return ultimo - primeiro == 0; // TODO: essa lógica não é consistente.
    }

    private void expandirFila() {
        throw new RuntimeException("O aluno, mais uma vez, não implementou!!!");
    }

    private T[] fila;
    private int primeiro = 0, ultimo = 0;

    private static final int CAPACIDADE_PADRAO = 128;
}
