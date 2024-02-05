package Inl1;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextAnalyzerTest {

    @Test
    public void testAnalyzeLineSingleWord() {

        TextAnalyzer textAnalyzer = new TextAnalyzer();

        textAnalyzer.analyzeLine("Hello");

        assertEquals(5, textAnalyzer.getCharacterCount());
        assertEquals(1, textAnalyzer.getLineCount());
    }

    @Test
    public void testAnalyzeLineMultipleWords() {

        TextAnalyzer textAnalyzer = new TextAnalyzer();


        textAnalyzer.analyzeLine("Hello world");

        assertEquals(11, textAnalyzer.getCharacterCount());
        assertEquals(1, textAnalyzer.getLineCount());
    }

    @Test
    public void testAnalyzeLineWithStopKeyword() {

        TextAnalyzer textAnalyzer = new TextAnalyzer();

        textAnalyzer.analyzeLine("Hello");
        textAnalyzer.analyzeLine("world");
        textAnalyzer.analyzeLine("stop");

        assertEquals(10, textAnalyzer.getCharacterCount());
        assertEquals(2, textAnalyzer.getLineCount());
    }
}
