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
            outputView.printInputMessage();
            String input = inputView.readInputNumber();
            Result result = baseball.calculate(input);
            checkResult(result);
        }
    }

    private void checkResult(Result result) {
        outputView.printResultMessage(result);

        if (result.getStrike() == 3) {
            outputView.printGameOver();
            outputView.printRestartMessage();
            String input = inputView.readRestartInput();
            checkRestart(input);
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
