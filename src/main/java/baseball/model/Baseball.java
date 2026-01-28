package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baseball {

    private Boolean stop;
    private String answer;

    public Baseball() {
        this.stop = false;
    }

    public String getAnswer() {
        return this.answer;
    }

    public Boolean getStop() {
        return this.stop;
    }

    public void createAnswer() {
        this.answer = generateRandomNumber();
        System.out.println("컴퓨터의 정답 숫자 3개가 생성되었습니다." + this.answer);
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
