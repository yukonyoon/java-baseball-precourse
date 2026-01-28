package baseball.view;

import baseball.model.Result;

public class OutputView {

    public void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
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
        System.out.println("낫싱");
    }

    private void printStrikerOrBall(Result result) {
        if (result.getStrike() > 0) {
            System.out.println(result.getStrike() + "스트라이크");
            return;
        }

        System.out.println(result.getBall() + "볼");
    }

    private void printStrikeAndBall(Result result) {
        System.out.println(result.getStrike() + "스트라이크 " + result.getBall() + "볼");
    }

    public void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
