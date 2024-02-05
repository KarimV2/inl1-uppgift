package Inl1;

import java.util.Scanner;


public class TextAnalyzer {


        private int characterCount;
        private int lineCount;

        public TextAnalyzer() {
                characterCount = 0;
                lineCount = 0;
        }

        public void analyzeLine(String line) {
                if (!line.equals("stop")) {
                        characterCount += line.length();
                        lineCount++;
                }
        }

        public int getCharacterCount() {
                return characterCount;
        }

        public int getLineCount() {
                return lineCount;
        }
}