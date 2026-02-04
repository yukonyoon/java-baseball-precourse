package baseball;

import baseball.controller.BaseballController;
import baseball.model.Baseball;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);

        Baseball baseball = new Baseball();

        BaseballController controller = new BaseballController(inputView, outputView, baseball);
        controller.run();
    }
}
