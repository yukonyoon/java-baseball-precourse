package baseball.util;

import java.util.HashSet;
import java.util.Set;

import static baseball.constant.ErrorMessage.*;

public class Validator {

    private static int THRESHOLD_INPUT_LENGTH = 3;

    public void validateInput(String input) {
        checkNumberType(input);
        checkNumberLength(input);
        checkDuplicateNumber(input);
    }

    public void validateRestart(String restart) {
        checkRestartType(restart);
    }

    private void checkRestartType(String restart) {
        if (!restart.equals("1") && !restart.equals("2")) {
            throw new IllegalArgumentException(NOT_ONE_OR_TWO_ERROR.getMessage());
        }
    }

    private void checkNumberType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
        }
    }

    private void checkNumberLength(String input) {
        if (input.length() != THRESHOLD_INPUT_LENGTH) {
            throw new IllegalArgumentException(NOT_THREE_DIGIT_NUMBER_ERROR.getMessage());
        }
    }

    private void checkDuplicateNumber(String input) {
        Set<Character> set = new HashSet<>();

        for (Character c : input.toCharArray()) {
            checkRange(c);

            if (set.contains(c)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR.getMessage());
            }

            set.add(c);
        }
    }

    private void checkRange(Character number) {
        if (number == null || !String.valueOf(number).matches("^[1-9]$")) {
            throw new IllegalArgumentException(ZERO_NUMBER_ERROR.getMessage());
        }
    }
}
