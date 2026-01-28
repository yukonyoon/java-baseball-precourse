package baseball.util;

public class Validator {

    private static int THRESHOLD_LENGTH = 3;

    public boolean validateInput(String input) {
        try{
            checkNumberType(input);
            checkNumberLength(input);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private void checkNumberType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] " + "숫자 형식이 압니다.");
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberLength(String input) {
        if (input.length() != THRESHOLD_LENGTH) {
            System.out.println("[ERROR] " + "입력 길이가 3이 아닙니다.");
            throw new IllegalArgumentException();
        }
    }
}
