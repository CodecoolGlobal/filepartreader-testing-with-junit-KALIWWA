import com.codecool.FilePartReader;
import com.codecool.FileWordAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    private FilePartReader filePartReader = new FilePartReader();
    private FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

    @Test
    void getWordsOrderedAlphabetically() {
        List<String> answer = new ArrayList<>(Arrays.asList("ada ada fada", "Adam", "line1", "line2 ss gg ss", "Line3", "line4 455", "Line5", "madam"));
        assertEquals(answer, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    void getWordsContainingSubstring() {
        List<String> answer = new ArrayList<>(Arrays.asList("ada", "ada", "fada", "madam"));
        assertEquals(answer, fileWordAnalyzer.getWordsContainingSubstring("ada"));
    }

    @Test
    void getStringsWhichPalindromes() {
        List<String> answer = new ArrayList<>(Arrays.asList("ss", "gg", "ss", "ada", "ada", "madam"));
        assertEquals(answer, fileWordAnalyzer.getStringsWhichPalindromes());
    }
}