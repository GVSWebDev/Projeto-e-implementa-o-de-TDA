import java.util.Iterator;
import java.util.Optional;

public class ListaEncadeada<T> implements Lista<T> {
    @Override
    public T acessar(int indice) {
        return getNo(indice).getValor();
    }

    @Override
    public void inserir(int indice, T obj) {
        if (inicio != null) {
            No<T> anterior = getNoAnterior(indice);
            No<T> inserido = new No<>(obj, anterior.getProximo().orElse(null));
            anterior.encadear(inserido);
        } else {
            inicio = new No<>(obj);
        }

        qtdElems++;
    }

    @Override
    public T remover(int indice) {
        No<T> anterior = getNoAnterior(indice);
        No<T> removido = anterior.desencadear().orElseThrow();
        anterior.encadear(removido.getProximo().orElse(null));

        if (inicio == removido) inicio = null;
        qtdElems--;
        return  removido.getValor();
    }

    @Override
    public Optional<Integer> pesquisar(T obj) {
        int contador = 0;
        No<T> iterador = inicio;
        while (iterador != null) {
            if (iterador.getValor().equals(obj))
                return Optional.of(contador);

            iterador = iterador.getProximo().orElse(null);
        }

        return Optional.empty();
    }

    @Override
    public int qtdeElems() {
        return qtdElems;
    }

    private No<T> getNoAnterior(int indice) {
        return indice > 0 ? getNo(indice-1) : inicio;
    }

    private No<T> getNo(int indice) {
        No<T> iterador = inicio;
        while (indice > 0) {
            iterador = iterador.getProximo().orElseThrow();
            indice--;
        }

        return  iterador;
    }

   // @Override
    //public Iterator<T> iterator() {
        //return new IteradorListaEncadeadaSimples<>(this);
    //}

    private No<T> inicio = null;
    private int qtdElems = 0;

    // Implementa esse cara **pelo amor de deus**, senão o iterador default é O(n^2)!!!
    //private class IteradorListaEncadeadaSimples<T> implements Iterator<T> {
        //public IteradorListaEncadeadaSimples(ListaEncadeada<T> ts) {
        //}
    //}
}
