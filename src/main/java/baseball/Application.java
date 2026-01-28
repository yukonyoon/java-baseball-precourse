package baseball;

import baseball.controller.BaseballController;
import baseball.model.Baseball;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Baseball baseball = new Baseball();

        BaseballController controller = new BaseballController(inputView, outputView, baseball);
        controller.run();
    }
}
