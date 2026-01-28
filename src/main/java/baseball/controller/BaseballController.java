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
        }
    }
}
