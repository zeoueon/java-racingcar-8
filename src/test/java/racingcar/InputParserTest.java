package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.converter.InputParser;

public class InputParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"aaa       , bbb", "  aaa, bbb"})
    void 자동차이름_변환_테스트(String carNames) {
        //given
        InputParser inputParser = new InputParser();

        //when
        List<String> carNamesList = inputParser.parseCarNamesToList(carNames);

        //then
        Assertions.assertThat(carNamesList).containsExactly("aaa", "bbb");
    }
}
