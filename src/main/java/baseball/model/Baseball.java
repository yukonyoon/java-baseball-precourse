package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baseball {

    private String answer;

    public Baseball() {

    }

    public String getAnswer() {
        return this.answer;
    }

    public void createAnswer() {
        this.answer = generateRandomNumber();
    }

    private String generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return "" + numbers.get(0) + numbers.get(1) + numbers.get(2);
    }
}
