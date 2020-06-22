import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class FilaIntegerCSV implements Fila<Integer>  {

    @Override
    public void enfileirar(Integer obj) {
        fila[ultimo] = obj;
        ultimo = ultimo + 1 >= fila.length ? 0 : ultimo+1;

        if (ultimo == primeiro) expandirFila();
    }

    @Override
    public Integer desenfileirar() {
        Integer desenfileirado = fila[primeiro];
        fila[primeiro] = null;
        primeiro = primeiro + 1 >= fila.length ? 0 : primeiro+1;

        return desenfileirado;
    }

    @Override
    public Integer olharPrimeiro() {
        return fila[primeiro];
    }

    @Override
    public int qtdeElems() {
        return primeiro < ultimo
                ? ultimo - primeiro
                : fila.length - (primeiro - ultimo);
    }

    @Override
    public boolean isVazia() {
        return ultimo - primeiro == 0;
    }

    private void expandirFila() {
        throw new RuntimeException("O aluno, mais uma vez, não implementou!!!");
    }

    private Integer[] fila;
    private int primeiro = 0, ultimo = 0;

    private static final int CAPACIDADE_PADRAO = 128;
}