package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    private static int THRESHOLD_INPUT_LENGTH = 3;

    public boolean validateInput(String input) {
        try{
            checkNumberType(input);
            checkNumberLength(input);
            checkDuplicateNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.print("숫자를 입력해주세요 : ");
            return false;
        }
        return true;
    }

    public boolean validateRestart(String restart) {
        try{
            checkRestartType(restart);
        } catch (IllegalArgumentException e) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return false;
        }
        return true;
    }

    private void checkRestartType(String restart) {
        if (!restart.equals("1") && !restart.equals("2")) {
            System.out.println("[ERROR] " + "1 혹은 2만 허용됩니다.");
            throw new IllegalArgumentException();
        }
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
        if (input.length() != THRESHOLD_INPUT_LENGTH) {
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
