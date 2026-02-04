package baseball.view;

import baseball.util.Validator;

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
        validator.validateInput(input);
        return input;
    }

    public String readRestartInput() {
        String restart = scanner.nextLine();
        validator.validateRestart(restart);
        return restart;
    }
}
