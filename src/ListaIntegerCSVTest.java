import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaIntegerCSVTest {

    @Test
    void inserir() {
        ListaIntegerCSV l = new ListaIntegerCSV();
        l.inserir(0, Integer.valueOf(20));
        l.inserir(1, Integer.valueOf(11));
        l.inserir(2, Integer.valueOf(48));
        assertEquals("20,11,48", l.getCsv());
    }

    @Test
    void remover() {
        ListaIntegerCSV l = new ListaIntegerCSV();
        l.inserir(0, Integer.valueOf(20));
        l.inserir(1, Integer.valueOf(11));
        l.inserir(2, Integer.valueOf(48));
        l.remover(2);
        assertEquals("20,11", l.getCsv());
    }
}