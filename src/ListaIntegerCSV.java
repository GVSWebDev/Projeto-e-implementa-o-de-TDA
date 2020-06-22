import java.util.Optional;

public class ListaIntegerCSV implements Lista<Integer> {

    String csv = "";

    @Override
    public Integer acessar(int indice) {
        return getNo(indice).getValor();
    }

    @Override
    public void inserir(int indice, Integer obj) {
        if(!isVazia()) csv += ","+obj.toString();
        else csv += obj.toString();
        if (inicio != null) {
            No<Integer> anterior = getNoAnterior(indice);
            No<Integer> inserido = new No<>(obj, anterior.getProximo().orElse(null));
            anterior.encadear(inserido);
        } else {
            inicio = new No<>(obj);
        }

        qtdElems++;
    }

    @Override
    public Integer remover(int indice) {
        No<Integer> anterior = getNoAnterior(indice);
        No<Integer> removido = anterior.desencadear().orElseThrow();
        anterior.encadear(removido.getProximo().orElse(null));

        if (inicio == removido) inicio = null;
        qtdElems--;
        csv = csv.substring(0, csv.length() - removido.getValor().toString().length() - 1);
        return  removido.getValor();
    }

    @Override
    public Optional<Integer> pesquisar(Integer obj) {
        int contador = 0;
        No<Integer> iterador = inicio;
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

    public String getCsv(){
        return csv;
    }

    private No<Integer> getNoAnterior(int indice) {
        return indice > 0 ? getNo(indice-1) : inicio;
    }

    private No<Integer> getNo(int indice) {
        No<Integer> iterador = inicio;
        while (indice > 0) {
            iterador = iterador.getProximo().orElseThrow();
            indice--;
        }

        return  iterador;
    }
    private No<Integer> inicio = null;
    private int qtdElems = 0;
}
