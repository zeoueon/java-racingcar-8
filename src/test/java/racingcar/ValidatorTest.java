package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorMessage;
import racingcar.validation.InputValidator;

public class ValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"5.5", "english"})
    void 시도할횟수_정수_예외테스트(String attemptCount) {
        //given
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateAttemptCount(attemptCount);
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.NOT_INTEGER_TYPE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-3"})
    void 시도할_횟수_0이하정수_예외테스트(String attemptCount) {
        //given
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateAttemptCount(attemptCount);
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.INVALID_ATTEMPT_COUNT);
    }

    @Test
    void 자동차이름_5자초과_예외테스트() {
        //given
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateCarNames("zeoueon, pobi");
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.INVALID_CAR_NAME_LENGTH);
    }

    @Test
    void 자동차이름_중복_예외테스트() {
        //given
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateCarNames("aaa, aaa");
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.NOT_DUPLICATE_CAR_NAMES);
    }
}
