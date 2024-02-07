import static org.junit.Assert.*;

import org.junit.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TestDocSearch {
    @Test
    public void testIndex() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        URI rootPath = new URI("http://localhost/");
        assertEquals(
                "There are 1391 total files to search.",
                h.handleRequest(rootPath));
    }

    @Test
    public void testSearch() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        URI rootPath = new URI("http://localhost/search?q=Resonance");
        String expect =
                "Found 2 paths:\n"
                        + "./technical/biomed/ar615.txt\n"
                        + "./technical/plos/journal.pbio.0020150.txt";
        assertEquals(expect, h.handleRequest(rootPath));
    }

    @Test
    public void testSearch2() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        URI rootPath = new URI("http://localhost/search?q=Jordan");
        String expect =
                "Found 15 paths:\n"
                    + "./technical/911report/chapter-11.txt\n"
                    + "./technical/911report/chapter-12.txt\n"
                    + "./technical/911report/chapter-13.2.txt\n"
                    + "./technical/911report/chapter-13.4.txt\n"
                    + "./technical/911report/chapter-13.5.txt\n"
                    + "./technical/911report/chapter-2.txt\n"
                    + "./technical/911report/chapter-6.txt\n"
                    + "./technical/911report/chapter-7.txt\n"
                    + "./technical/911report/chapter-8.txt\n"
                    + "./technical/biomed/cvm-2-6-286.txt\n"
                    + "./technical/government/Alcohol_Problems/Session3-PDF.txt\n"
                    + "./technical/government/Media/Domestic_Violence_Ruling.txt\n"
                    + "./technical/government/Media/Workers_aid_center.txt\n"
                    + "./technical/plos/pmed.0020060.txt\n"
                    + "./technical/plos/pmed.0020191.txt";
        assertEquals(expect, h.handleRequest(rootPath));
    }

    @Test
    public void testSearch3() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        URI rootPath = new URI("http://localhost/search?q=powerless");
        String expect =
                "Found 3 paths:\n"
                    + "./technical/911report/chapter-13.4.txt\n"
                    + "./technical/government/Gen_Account_Office/ai00134.txt\n"
                    + "./technical/government/Media/Politician_Practices.txt";
        assertEquals(expect, h.handleRequest(rootPath));
    }

    @Test
    public void testSearch4() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        URI rootPath = new URI("http://localhost/search?q=hello");
        String expect = "Found 0 paths:\n";
        assertEquals(expect, h.handleRequest(rootPath));
    }
}
