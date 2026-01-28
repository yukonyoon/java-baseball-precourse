package baseball.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }

    @Test
    @DisplayName("숫자 형식이 아닌 입력이 들어오면 예외를 발생시킨다.")
    void 숫자_입력_예외_테스트_1() throws Exception {
        // given
        String input = "aaa";

        // when
        boolean result = validator.validateInput(input);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("입력의 길이가 3 이상인 경우 예외를 발생시킨다.")
    void 숫자_입력_예외_테스트_2() throws Exception {
        // given
        String input = "1234";

        // when
        boolean result = validator.validateInput(input);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("각 자리가 1~9의 범위를 벗어나는 경우 예외를 발생시킨다.")
    void 숫자_입력_예외_테스트_3() throws Exception {
        // given
        String input = "012";

        // when
        boolean result = validator.validateInput(input);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("중복된 숫자가 포함된 경우 예외를 발생시킨다.")
    void 숫자_입력_예외_테스트_4() throws Exception {
        // given
        String input = "111";

        // when
        boolean result = validator.validateInput(input);

        // then
        assertThat(result).isFalse();
    }
}
