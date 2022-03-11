import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void testLink() throws IOException {
        String regFile = Files.readString(Path.of("./test-file.md"));
        String[] regLines = regFile.split("\n");
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(regLines));
    }

    @Test
    public void testSnippet1() throws IOException {
        String regFile = Files.readString(Path.of("./snippet-1.md"));
        String[] regLines = regFile.split("\n");
        assertEquals(List.of("url.com", "`google.com", "google.com", "ucsd.edu"), MarkdownParse.getLinks(regLines));
    }

    @Test
    public void testSnippet2() throws IOException {
        String regFile = Files.readString(Path.of("./snippet-2.md"));
        String[] regLines = regFile.split("\n");
        assertEquals(List.of("a.com", "a.com(())", "example.com"), MarkdownParse.getLinks(regLines));
    }

    @Test
    public void testSnippet3() throws IOException {
        String regFile = Files.readString(Path.of("./snippet-3.md"));
        String[] regLines = regFile.split("\n");
        assertEquals(List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", 
            "https://cse.ucsd.edu/"), MarkdownParse.getLinks(regLines));
    }
}