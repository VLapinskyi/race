package ua.com.foxminded.task_6.core;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParcerTest {

    private File abbreviations;
    private File start;
    private File end;
    private Parcer parcer;
    private List <Racer> expected;

    @BeforeEach
    public void init () {
        abbreviations = this.readFile("abbreviations.txt");
        start = this.readFile("start.log");
        end = this.readFile("end.log");
        parcer = new Parcer();

        expected = new ArrayList<>(Arrays.asList(
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
                new Racer("BHS", "Brendon Hartley", "SCUDERIA TORO ROSSO HONDA", 73179L)));
    }

    @Test
    public void shouldReturnCorrectList() {
        assertEquals(expected, parcer.parceRacers(abbreviations, start, end));
    }

    private File readFile(String path) {
        String getPath = getClass().getClassLoader().getResource(path).getFile();
        try {
            getPath = URLDecoder.decode(getPath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.toString());
        }
        return new File(getPath);
    }

}
