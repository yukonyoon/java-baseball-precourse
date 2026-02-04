package baseball.util;

import java.util.HashSet;
import java.util.Set;

import static baseball.constant.ErrorMessage.*;
import static baseball.constant.InputMessage.*;

public class Validator {

    private static int THRESHOLD_INPUT_LENGTH = 3;

    public boolean validateInput(String input) {
        try{
            checkNumberType(input);
            checkNumberLength(input);
            checkDuplicateNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.print(INPUT_MESSAGE.getMessage());
            return false;
        }
        return true;
    }

    public boolean validateRestart(String restart) {
        try{
            checkRestartType(restart);
        } catch (IllegalArgumentException e) {
            System.out.println(RESTART_MESSAGE.getMessage());
            return false;
        }
        return true;
    }

    private void checkRestartType(String restart) {
        if (!restart.equals("1") && !restart.equals("2")) {
            System.out.println(NOT_ONE_OR_TWO_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMBER_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberLength(String input) {
        if (input.length() != THRESHOLD_INPUT_LENGTH) {
            System.out.println(NOT_THREE_DIGIT_NUMBER_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumber(String input) {
        Set<Character> set = new HashSet<>();

        for (Character c : input.toCharArray()) {
            checkRange(c);

            if (set.contains(c)) {
                System.out.println(DUPLICATE_NUMBER_ERROR.getMessage());
                throw new IllegalArgumentException();
            }

            set.add(c);
        }
    }

    private void checkRange(Character number) {
        if (number == null || !String.valueOf(number).matches("^[1-9]$")) {
            System.out.println(ZERO_NUMBER_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
