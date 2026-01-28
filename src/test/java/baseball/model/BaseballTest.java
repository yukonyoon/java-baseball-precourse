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

    @BeforeEach
    public void setUp() {
       baseball = new Baseball();
    }

    @Test
    @DisplayName("컴퓨터가 3자리의, 중복이 없으며, 1~9 사이의 숫자를 생성할 수 있다.")
    void 컴퓨터_정답_숫자_생성_테스트() throws Exception {
        // given
        baseball.createAnswer();

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
}
