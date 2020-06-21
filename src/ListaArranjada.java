import java.util.Optional;

public class ListaArranjada<T> implements Lista<T> {

    @SuppressWarnings("unchecked")
    public ListaArranjada(int capacidade) {
        lista = (T[]) new Object[capacidade];
    }
    public ListaArranjada() {
        this(CAPACIDADE_PADRAO);
    }

    @Override
    public T acessar(int indice) {
        if (0 > indice || indice >= qtdElems) throw new RuntimeException("Caiu do fim da terra plana.");

        return lista[indice];
    }

    @Override
    public void inserir(int indice, T obj) {
        if (0 > indice || indice >= qtdElems) throw new RuntimeException("Caiu do fim da terra plana.");

        if (qtdElems >= lista.length) expandirArranjo();

        deslocarParaFim(indice, qtdElems);
        lista[indice] = obj;
        qtdElems++;
    }

    @Override
    public T remover(int indice) {
        if (0 > indice || indice >= qtdElems) throw new RuntimeException("Caiu do fim da terra plana.");

        if (qtdElems <= lista.length/4) reduzirArranjo();

        T removido = lista[indice];
        deslocarParaInicio(indice, qtdElems);
        qtdElems--;

        lista[qtdElems] = null;
        return removido;
    }

    /**
     * O(n), Omega(1)
     * @param obj
     * @return
     */
    @Override
    public Optional<Integer> pesquisar(T obj) {
        for (int i = 0; i < qtdElems; i++)
            if (lista[i].equals(obj))
                return Optional.of(i);

        return Optional.empty();
    }

    @Override
    public int qtdeElems() {
        return qtdElems;
    }

    // Se eu não implementar, o java vai utilizar a implementação default da interface
    /*@Override
    public boolean isVazia() {
        return qtdElems == 0;
    }*/

    private void deslocarParaFim(int inicio, int fim) {
        for (int i = fim; i > inicio; i--)
            lista[i] = lista[i-1];
    }

    private void deslocarParaInicio(int inicio, int fim) {
        for (int i = inicio; i < fim; i++) {
            lista[i] = lista[i+1];
        }
    }

    private void expandirArranjo() {
        throw new RuntimeException("Faz esse negócio, menino!");
    }

    private void reduzirArranjo() {
        throw new RuntimeException("Faz esse negócio, menino!");
    }

    private T[] lista;
    private int qtdElems = 0;

    private static final int CAPACIDADE_PADRAO = 128;
}
