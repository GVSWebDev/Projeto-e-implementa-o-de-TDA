import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface Lista<T> extends Colecoes<T>, Iterable<T> {
    /**
     * Retorna o elemento da lista do indice especificado.
     * @param indice
     * @return
     */
    T acessar(int indice);

    /**
     * Insere um elemento obj ao indice especificado.
     * @param indice
     * @param obj
     */
    void inserir(int indice, T obj);

    /**
     * Remove o elemento na fila do indice especificado.
     * @param indice
     * @return
     */
    T remover(int indice);

    Optional<Integer> pesquisar(T obj);

    /**
     * Verifica se o elemento obj está presente na lista.
     * @param obj
     * @return
     */
    default boolean contem(T obj) {
        return pesquisar(obj).isPresent();
    }

    /**
     * Armazena as posições de todos os nós.
     * @return
     */
    @Override
    default Iterator<T> iterator() {
        return new IteradorLista<>(this);
    }

    class IteradorLista<T> implements Iterator<T> {

        IteradorLista(Lista<T> listaAIterar) {
            this.lista = listaAIterar;
        }

        /**
         * Verifica se existe um próximo indice para ser acessado.
         * @return
         */
        @Override
        public boolean hasNext() {
            return idxProxElem < lista.qtdeElems();
        }

        /**
         * Acessa o elemento do proximo indice que está sendo acessado.
         * @return
         */
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
