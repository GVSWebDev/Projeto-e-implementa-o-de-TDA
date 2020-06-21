public class PilhaArranjada<T> implements Pilha<T> {

    @SuppressWarnings("unchecked")
    public PilhaArranjada(int capacidade) {
        pilha = (T[]) new Object[capacidade];
    }
    public PilhaArranjada() {
        this(CAPACIDADE_PADRAO);
    }

    /**
     * O(n), Omega(1)
     * @param obj
     */
    @Override
    public void empilhar(T obj) {
        if (topo >= pilha.length) expandirPilha();

        pilha[topo] = obj;
        topo++;
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public T desempilhar() {
        topo--;
        T desempilhado = pilha[topo];
        pilha[topo] = null;

        return desempilhado;
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public T olharTopo() {
        return pilha[topo-1];
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public int qtdeElems() {
        return topo;
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public boolean isVazia() {
        return topo <= 0;
    }

    private void expandirPilha() {
        T[] pilhaNova = (T[]) new Object[pilha.length*2];
        for (int i = 0; i < pilha.length; i++) pilhaNova[i] = pilha[i];
        pilha = pilhaNova;
    }

    private T[] pilha;
    private int topo = 0;

    private static final int CAPACIDADE_PADRAO = 128;
}
