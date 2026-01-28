package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    private static int THRESHOLD_LENGTH = 3;

    public boolean validateInput(String input) {
        try{
            checkNumberType(input);
            checkNumberLength(input);
            checkDuplicateNumber(input);
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

    private void checkDuplicateNumber(String input) {
        Set<Character> set = new HashSet<>();

        for (Character c : input.toCharArray()) {
            checkRange(c);

            if (set.contains(c)) {
                System.out.println("[ERROR] " + "중복된 숫자가 포함되어 있습니다.");
                throw new IllegalArgumentException();
            }

            set.add(c);
        }
    }

    private void checkRange(Character number) {
        if (number == null || !String.valueOf(number).matches("^[1-9]$")) {
            System.out.println("[ERROR] " + "0~9 숫자만 허용됩니다.");
            throw new IllegalArgumentException();
        }
    }
}
