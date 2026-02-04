package baseball.view;

import baseball.util.Validator;

import java.io.Console;
import java.io.PushbackInputStream;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final Validator validator;
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
        this.outputView = outputView;
    }

    public String readInputNumber() {
        String input = scanner.nextLine();
        while (true) {
            try {
                validator.validateInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
                outputView.printInputMessage();
                input = scanner.nextLine();
            }
        }
    }

    public String readRestartInput() {
        String restart = scanner.nextLine();
        while (true) {
            try {
                validator.validateRestart(restart);
                return restart;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
                outputView.printRestartMessage();
                restart = scanner.nextLine();
            }
        }
    }
}
