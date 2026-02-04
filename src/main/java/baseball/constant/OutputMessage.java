package baseball.constant;

public enum OutputMessage {

    NOTHING("낫싱"),
    STRIKE("스트라이크"),
    BALL("볼"),
    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 끝")
    ;

    private String message;

    public String getMessage() {
        return message;
    }

    OutputMessage (String message) {
        this.message = message;
    }
}
