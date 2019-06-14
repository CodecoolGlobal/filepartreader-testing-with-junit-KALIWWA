import com.codecool.FilePartReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilePartReaderTest {

    private FilePartReader filePartReader = new FilePartReader();


    @org.junit.jupiter.api.Test
    void read() throws IOException {
        String answer = "line1,line2 ss gg ss,Line3,line4 455,Line5,ada ada fada,Adam,madam";
        assertEquals(answer, filePartReader.read());
    }

    @org.junit.jupiter.api.Test
    void readLines() {
        String answer = "line1,line2 ss gg ss,Line3,line4 455,Line5,ada ada fada,Adam,madam";
        assertEquals(answer, filePartReader.readLines());
    }

    @org.junit.jupiter.api.Test
    void readLines1() {
        String answer = "line2 ss gg ss,Line3,line4 455";
        assertEquals(answer, filePartReader.readLines(2,4));
    }
}