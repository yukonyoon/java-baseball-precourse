package baseball.util;

public class Validator {

    public boolean validateInput(String input) {
        try{
            checkNumberType(input);
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
}
