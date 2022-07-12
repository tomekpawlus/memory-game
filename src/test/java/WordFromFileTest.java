import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.tmpw.WordFromFile;
import com.tmpw.WordGenerator;

import java.io.FileNotFoundException;

class WordFromFileTest {
    @Test
    void generateWordWhenFileFound() throws FileNotFoundException {

        //given
        WordGenerator wordGenerator = new WordFromFile();
        //when
        String word = wordGenerator.generateWord();
        //then
        System.out.println(word);
        Assertions.assertNotNull(word, "Word should not be null");
    }

}