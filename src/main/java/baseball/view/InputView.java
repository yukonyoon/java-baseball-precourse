package baseball.view;

import java.io.Console;
import java.io.PushbackInputStream;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int readInputNumber() {
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
