package Inl1;

import java.util.Scanner;

public class TextInputManager {
    private Scanner scanner;

    public TextInputManager() {
        scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}