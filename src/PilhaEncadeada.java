import java.util.Optional;

class PilhaEncadeada <T> implements Pilha<T> {

    /**
     * Theta(1)
     * @param obj
     */
    @Override
    public void empilhar(T obj) {
        topo = new No<>(obj, topo);
        qtdeElems++;

        /*if (topo.isEmpty()) {
            topo = Optional.of(new No(obj));
        } else {
            //Cria o no, seta o proximo, e transfere a referencia do topo
            No objNo = new No(obj, topo.get());
            topo = Optional.of(objNo);
        }*/
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public T desempilhar() {
        qtdeElems--;

        No<T> removido = this.topo;
        this.topo = removido.desencadear().orElse(null);
        return removido.getValor();

        /*if (topo.isPresent()) {
            No removido = topo.get();
            topo = removido.proximo;
            return removido;
        } else throw new RuntimeException("Vc desempilhou a mesa, animal!");*/
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public T olharTopo() {
        return topo.getValor();
        /*if (topo.isPresent()) return topo.get();
        throw new RuntimeException("Vc olhou a mesa, animal!");*/
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public int qtdeElems() {
        return qtdeElems;

        // Theta(n), n é a quantidade e elementos da Pilha.
        /*int qtde = 0;
        No<T> iterador = topo;
        while (iterador != null) {
            qtde++;
            iterador = iterador.getProximo().orElse(null);
        }

        return qtde;*/
    }

    /**
     * Theta(1)
     * @return
     */
    @Override
    public boolean isVazia() {
        return topo == null;
    }

    private int qtdeElems = 0;
    private No<T> topo = null;
}
