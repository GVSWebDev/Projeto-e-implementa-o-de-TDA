import java.util.Optional;

class No<T> {

    public No(T valor) {
        this(valor, null);
    } // Theta(1)
    public No(T valor, No<T> proximo) { // Theta(1)
        this.valor = valor; this.proximo = proximo;
    }

    public void encadear(No<T> proximo) {
        this.proximo = proximo;
    }

    /**
     * Theta(1)
     * @return
     */
    public Optional<No<T>> desencadear() {
        No<T> desencadeado = proximo;
        proximo = null;
        return Optional.ofNullable(desencadeado);
    }

    public boolean isEncadeado() {
        return proximo != null;
    }

    /**
     * Theta(1)
     * @return
     */
    public T getValor() {
        return valor;
    }

    public Optional<No<T>> getProximo() {
        return Optional.ofNullable(proximo);
    }

    private T valor;
    private No<T> proximo;
}
