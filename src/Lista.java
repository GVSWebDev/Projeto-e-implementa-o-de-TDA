import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface Lista<T> extends Colecoes<T>, Iterable<T> {
    T acessar(int indice);

    void inserir(int indice, T obj);

    T remover(int indice);

    Optional<Integer> pesquisar(T obj);

    default boolean contem(T obj) {
        return pesquisar(obj).isPresent();
    }

    @Override
    default Iterator<T> iterator() {
        return new IteradorLista<>(this);
    }

    class IteradorLista<T> implements Iterator<T> {

        IteradorLista(Lista<T> listaAIterar) {
            this.lista = listaAIterar;
        }

        @Override
        public boolean hasNext() {
            return idxProxElem < lista.qtdeElems();
        }

        @Override
        public T next() {
            T next = lista.acessar(idxProxElem);
            idxProxElem++;
            return next;
        }

        private int idxProxElem = 0;
        private Lista<T> lista;
    }
}
