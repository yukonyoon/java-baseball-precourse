package baseball.constant;

public enum ErrorMessage {

    NOT_ONE_OR_TWO_ERROR("[ERROR] " + "1 혹은 2만 허용됩니다."),
    NOT_NUMBER_ERROR("[ERROR] " + "숫자 형식이 압니다."),
    NOT_THREE_DIGIT_NUMBER_ERROR("[ERROR] " + "입력 길이가 3이 아닙니다."),
    DUPLICATE_NUMBER_ERROR("[ERROR] " + "중복된 숫자가 포함되어 있습니다."),
    ZERO_NUMBER_ERROR("[ERROR] " + "1~9 숫자만 허용됩니다.")
    ;

    private String message;

    public String getMessage() {
        return message;
    }

    ErrorMessage (String message) {
        this.message = message;
    }
}
