package baseball.model;

import java.util.*;

public class Baseball {

    private Boolean stop;
    private String answer;
    private Set<Character> set;

    public Baseball() {
        this.stop = false;
        this.answer = generateRandomNumber();
        this.set = createSet(answer);

        System.out.println("컴퓨터의 정답 숫자 3개가 생성되었습니다." + this.answer);
    }

    public Baseball(String answer) {
        this.stop = false;
        this.answer = answer;
        this.set = createSet(answer);
    }

    public String getAnswer() {
        return this.answer;
    }

    public Boolean getStop() {
        return this.stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void setAnswer() {
        this.answer = generateRandomNumber();
        this.set = createSet(answer);

        System.out.println("컴퓨터의 정답 숫자 3개가 생성되었습니다." + this.answer);
    }

    private Set<Character> createSet(String answer) {
        Set<Character> set = new HashSet<>();
        for (char c : answer.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    private String generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return "" + numbers.get(0) + numbers.get(1) + numbers.get(2);
    }

    public Result calculate(String input) {
        int ball = calculateBall(input);
        int strike = calculateStrike(input);

        return new Result(strike, ball - strike);
    }

    private int calculateBall(String input) {
        int ball = 0;
        for (char num : input.toCharArray()) {
            if (set.contains(num)) ball++;
        }

        return  ball;
    }

    private int calculateStrike(String input) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.substring(i, i + 1).equals(input.substring(i, i + 1))) strike++;
        }

        return strike;
    }
}
