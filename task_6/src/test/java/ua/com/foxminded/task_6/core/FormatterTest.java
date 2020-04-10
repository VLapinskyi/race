package ua.com.foxminded.task_6.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FormatterTest {

    @Mock
    private Parcer parcer;
    private File file;

    Formatter formatter;
    String expected;

    @BeforeEach
    public void init () {
        MockitoAnnotations.initMocks(this);	
        when(parcer.parceRacers(file, file, file)).thenReturn(new ArrayList<Racer>(Arrays.asList(
                new Racer("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER", 72013L),
                new Racer("SVF", "Sebastian Vettel", "FERRARI", 64415L),
                new Racer("LHM", "Lewis Hamilton", "MERCEDES", 72460L),
                new Racer("KRF", "Kimi Raikkonen", "FERRARI", 72639L),
                new Racer("VBM", "Valtteri Bottas", "MERCEDES", 72434L),
                new Racer("EOF", "Esteban Ocon", "FORCE INDIA MERCEDES", 73028L),
                new Racer("FAM", "Fernando Alonso", "MCLAREN RENAULT", 72657L),
                new Racer("CSR", "Carlos Sainz", "RENAULT", 72950L),
                new Racer("SPF", "Sergio Perez", "FORCE INDIA MERCEDES", 72848L),
                new Racer("PGS", "Pierre Gasly", "SCUDERIA TORO ROSSO HONDA", 72941L),
                new Racer("NHR", "Nico Hulkenberg", "RENAULT", 73065L),
                new Racer("SVM", "Stoffel Vandoorne", "MCLAREN RENAULT", 72463L),
                new Racer("SSW", "Sergey Sirotkin", "WILLIAMS MERCEDES", 72706L),
                new Racer("CLS", "Charles Leclerc", "SAUBER FERRARI", 72829L),
                new Racer("RGH", "Romain Grosjean", "HAAS FERRARI", 72930L),
                new Racer("BHS", "Brendon Hartley", "SCUDERIA TORO ROSSO HONDA", 73179L))));

        formatter = new Formatter();

        expected = "1. Sebastian Vettel  | FERRARI                   | 1:04.415\n" + 
                "2. Daniel Ricciardo  | RED BULL RACING TAG HEUER | 1:12.013\n" + 
                "3. Valtteri Bottas   | MERCEDES                  | 1:12.434\n" + 
                "4. Lewis Hamilton    | MERCEDES                  | 1:12.460\n" + 
                "5. Stoffel Vandoorne | MCLAREN RENAULT           | 1:12.463\n" + 
                "6. Kimi Raikkonen    | FERRARI                   | 1:12.639\n" + 
                "7. Fernando Alonso   | MCLAREN RENAULT           | 1:12.657\n" + 
                "8. Sergey Sirotkin   | WILLIAMS MERCEDES         | 1:12.706\n" + 
                "9. Charles Leclerc   | SAUBER FERRARI            | 1:12.829\n" + 
                "10. Sergio Perez     | FORCE INDIA MERCEDES      | 1:12.848\n" + 
                "11. Romain Grosjean  | HAAS FERRARI              | 1:12.930\n" + 
                "12. Pierre Gasly     | SCUDERIA TORO ROSSO HONDA | 1:12.941\n" + 
                "13. Carlos Sainz     | RENAULT                   | 1:12.950\n" + 
                "14. Esteban Ocon     | FORCE INDIA MERCEDES      | 1:13.028\n" + 
                "15. Nico Hulkenberg  | RENAULT                   | 1:13.065\n" + 
                "-----------------------------------------------------------\n" + 
                "16. Brendon Hartley  | SCUDERIA TORO ROSSO HONDA | 1:13.179";
    }

    @Test
    public void shouldFormatStringCorrectly() {
        ArrayList<Racer> racers = (ArrayList<Racer>) parcer.parceRacers(file, file, file);
        String actual = formatter.format(racers);
        assertEquals(expected, actual);
    }

}
