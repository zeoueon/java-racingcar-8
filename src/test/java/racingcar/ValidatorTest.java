package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.validation.InputValidator;

public class ValidatorTest {

    @Test
    void 시도할횟수_정수_예외테스트() {
        //given
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateAttemptCount("5.5");
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.NOT_INTEGER_TYPE);
    }

    @Test
    void 시도할_횟수_0이하정수_예외테스트() {
        //given
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateAttemptCount("0");
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
