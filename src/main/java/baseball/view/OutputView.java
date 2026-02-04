package baseball.view;

import baseball.model.Result;

import static baseball.constant.InputMessage.*;
import static baseball.constant.OutputMessage.*;

public class OutputView {

    public void printInputMessage() {
        System.out.print(INPUT_MESSAGE.getMessage());
    }

    public void printResultMessage(Result result) {
        if (result.getStrike() == 0 && result.getBall() == 0) {
            printNothing();
            return;
        }

        if (result.getStrike() == 0 || result.getBall() == 0) {
            printStrikerOrBall(result);
            return;
        }

        printStrikeAndBall(result);
    }

    private void printNothing() {
        System.out.println(NOTHING);
    }

    private void printStrikerOrBall(Result result) {
        if (result.getStrike() > 0) {
            System.out.println(result.getStrike() + STRIKE.getMessage());
            return;
        }

        System.out.println(result.getBall() + BALL.getMessage());
    }

    private void printStrikeAndBall(Result result) {
        System.out.println(result.getStrike() + STRIKE.getMessage() + " " + result.getBall() + BALL.getMessage());
    }

    public void printGameOver() {
        System.out.println(GAME_OVER.getMessage());
    }

    public void printRestartMessage() {
        System.out.println(RESTART_MESSAGE.getMessage());
    }
}
