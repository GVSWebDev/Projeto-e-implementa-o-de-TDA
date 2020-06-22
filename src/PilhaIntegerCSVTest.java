import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilhaIntegerCSVTest {

    @Test
    void empilhar() {
        PilhaIntegerCSV p = new PilhaIntegerCSV();
        p.empilhar(Integer.valueOf(20));
        p.empilhar(Integer.valueOf(11));
        p.empilhar(Integer.valueOf(48));
        assertEquals("20,11,48", p.getCsv());
    }

    @Test
    void desempilhar() {
        PilhaIntegerCSV p = new PilhaIntegerCSV();
        p.empilhar(Integer.valueOf(20));
        p.empilhar(Integer.valueOf(11));
        p.empilhar(Integer.valueOf(48));
        p.desempilhar();
        assertEquals("20,11", p.getCsv());
    }
}