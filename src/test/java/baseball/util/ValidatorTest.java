package baseball.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

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

        // when & then
        assertThatThrownBy(() -> validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 형식");
    }

    @Test
    @DisplayName("입력의 길이가 3 이상인 경우 예외를 발생시킨다.")
    void 숫자_입력_예외_테스트_2() throws Exception {
        // given
        String input = "1234";

        // when & then
        assertThatThrownBy(() -> validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("길이가 3");
    }

    @Test
    @DisplayName("각 자리가 1~9의 범위를 벗어나는 경우 예외를 발생시킨다.")
    void 숫자_입력_예외_테스트_3() throws Exception {
        // given
        String input = "012";

        // when & then
        assertThatThrownBy(() -> validator
                .validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9");
    }

    @Test
    @DisplayName("중복된 숫자가 포함된 경우 예외를 발생시킨다.")
    void 숫자_입력_예외_테스트_4() throws Exception {
        // given
        String input = "111";

        // when & then
        assertThatThrownBy(() -> validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("재시작 입력이 1 혹은 2인 경우 성공한다.")
    void 재시작_입력_테스트() throws Exception {
        // given
        String restart = "2";

        // when & then
        assertThatCode(() -> validator.validateRestart(restart))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("재시작 입력이 1과 2가 아닌 경우 예외를 발생시킨다.")
    void 재시작_입력_예외_테스트_1() throws Exception {
        // given
        String restart = "3";

        // when & then
        assertThatThrownBy(() -> validator.validateRestart(restart))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 혹은 2");
    }

    @Test
    @DisplayName("유효한 숫자 입력이 들어오면 예외를 발생시키지 않는다.")
    void 숫자_입력_성공_테스트() throws Exception {
        // given
        String input = "123";

        // when & then
        assertThatCode(() -> validator.validateInput(input))
                .doesNotThrowAnyException();
    }
}
