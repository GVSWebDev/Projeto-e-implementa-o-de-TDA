class PilhaIntegerCSV implements Pilha<Integer> {
    private String csv;
    private Integer[] pilha;
    private int topo = 0;

    private static final int CAPACIDADE_PADRAO = 128;

    public PilhaIntegerCSV(int capacidade) {
        pilha = new Integer[capacidade];
    }
    public PilhaIntegerCSV() {
        this(CAPACIDADE_PADRAO);
    }

    /**
     * O(n), Omega(1)
     * @param obj
     */
    @Override
    public void empilhar(Integer obj) {
        if (topo >= pilha.length) expandirPilha();
        pilha[topo] = obj;
        topo++;
        csv += ","+obj.toString();
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public Integer desempilhar() {
        topo--;
        Integer desempilhado = pilha[topo];
        pilha[topo] = null;
        csv = csv.substring(0, csv.length() - desempilhado.toString().length() + 1);
        return desempilhado;
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public Integer olharTopo() {
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
        Integer[] pilhaNova = (Integer[]) new Object[pilha.length*2];
        for (int i = 0; i < pilha.length; i++) pilhaNova[i] = pilha[i];
        pilha = pilhaNova;
    }
}
