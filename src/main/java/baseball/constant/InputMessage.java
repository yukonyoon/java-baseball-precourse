package baseball.constant;

public enum InputMessage {

    INPUT_MESSAGE("숫자를 입력해주세요 : "),
    RESTART_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    ;

    private String message;

    public String getMessage() {
        return message;
    }

    InputMessage (String message) {
        this.message = message;
    }
}
