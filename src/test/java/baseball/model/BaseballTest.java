package baseball.model;

import baseball.util.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BaseballTest {

    private Baseball baseball;

    @Test
    @DisplayName("컴퓨터가 3자리의, 중복이 없으며, 1~9 사이의 숫자를 생성할 수 있다.")
    void 컴퓨터_정답_숫자_생성_테스트() throws Exception {
        // given
        baseball = new Baseball();

        // when
        String number = baseball.getAnswer();

        // then
        assertNotNull(number);
        assertEquals(3, number.length(), "숫자는 3자리여야 합니다");

        Set<Character> set = new HashSet<>();

        for (char c : number.toCharArray()) {
            assertTrue(c >= '1' && c <= '9', "각 자리는 1~9 사이여야 합니다: " + c);
            set.add(c);
        }

        assertEquals(3, set.size(),"숫자는 중복되면 안 됩니다: " + number);
    }

    @Test
    @DisplayName("모든 숫자가 같으면 3 스트라이크 0 볼")
    void 스트라이크_3_테스트() {
        // given
        baseball = new Baseball("123");

        // when
        Result result = baseball.calculate("123");

        // then
        assertEquals(3, result.getStrike());
        assertEquals(0, result.getBall());
    }

    @Test
    @DisplayName("자리는 다르지만 숫자가 모두 존재하면 0 스트라이크 3 볼")
    void 볼_3_테스트() {
        // given
        baseball = new Baseball("123");

        // when
        Result result = baseball.calculate("312");

        // then
        assertEquals(0, result.getStrike());
        assertEquals(3, result.getBall());
    }

    @Test
    @DisplayName("1 스트라이크 2 볼")
    void 스트라이크_1_볼_2_테스트() {
        // given
        baseball = new Baseball("123");

        // when
        Result result = baseball.calculate("132");

        // then
        assertEquals(1, result.getStrike());
        assertEquals(2, result.getBall());
    }

    @Test
    @DisplayName("겹치는 숫자가 없으면 0 스트라이크 0 볼")
    void 낫싱_테스트() {
        // given
        baseball = new Baseball("123");

        // when
        Result result = baseball.calculate("456");

        // then
        assertEquals(0, result.getStrike());
        assertEquals(0, result.getBall());
    }
}
