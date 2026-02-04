package baseball.controller;

import baseball.model.Baseball;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;

    private final Baseball baseball;

    public BaseballController(
            InputView inputView,
            OutputView outputView,
            Baseball baseball
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseball = baseball;
    }

    public void run() {
        while (!baseball.getStop()) {
            String input = readInputWithRetry();
            Result result = baseball.calculate(input);
            checkResult(result);
        }
    }

    private String readInputWithRetry() {
        while (true) {
            try {
                outputView.printInputMessage();
                return inputView.readInputNumber();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void checkResult(Result result) {
        outputView.printResultMessage(result);

        if (result.getStrike() == 3) {
            outputView.printGameOver();
            String input = readRestartInputWithRetry();
            checkRestart(input);
        }
    }

    private String readRestartInputWithRetry() {
        while (true) {
            try {
                outputView.printRestartMessage();
                return inputView.readRestartInput();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void checkRestart(String input) {
        if (input.equals("2")) {
            baseball.setStop(true);
            return;
        }

        baseball.setAnswer();
    }
}
