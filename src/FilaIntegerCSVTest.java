import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaIntegerCSVTest {

    @Test
    void enfileirar() {
        FilaIntegerCSV f = new FilaIntegerCSV();
        f.enfileirar(Integer.valueOf(20));
        f.enfileirar(Integer.valueOf(11));
        f.enfileirar(Integer.valueOf(48));
        assertEquals("20,11,48", f.getCsv());
    }

    @Test
    void desenfileirar() {
        FilaIntegerCSV f = new FilaIntegerCSV();
        f.enfileirar(Integer.valueOf(20));
        f.enfileirar(Integer.valueOf(11));
        f.enfileirar(Integer.valueOf(48));
        f.desenfileirar();
        assertEquals("20,11,48", f.getCsv());
    }
}