package Inl1;

public class Main {
    public static void main(String[] args) {
        TextInputManager inputManager = new TextInputManager();
        TextAnalyzer textAnalyzer = new TextAnalyzer();

        System.out.println("Skriv in text rad för rad. Skriv 'stop' när du är klar.");

        while (true) {
            String line = inputManager.readLine();
            textAnalyzer.analyzeLine(line);

            if (line.equals("stop")) {
                break;
            }
        }

        inputManager.close();

        int characterCount = textAnalyzer.getCharacterCount();
        int lineCount = textAnalyzer.getLineCount();

        System.out.println("Antal tecken: " + characterCount);
        System.out.println("Antal rader: " + lineCount);
    }
}