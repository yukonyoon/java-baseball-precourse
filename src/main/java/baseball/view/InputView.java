package baseball.view;

import baseball.util.Validator;

import java.io.Console;
import java.io.PushbackInputStream;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final Validator validator;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
    }

    public String readInputNumber() {
        String input = scanner.nextLine();
        while (!validator.validateInput(input)) {
            input = scanner.nextLine();
        }
        return input;
    }

    public String readRestartInput() {
        String restart = scanner.nextLine();
        while (!validator.validateRestart(restart)) {
            restart = scanner.nextLine();
        }
        return restart;
    }
}
