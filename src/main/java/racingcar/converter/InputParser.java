package racingcar.converter;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public List<String> parseCarNamesToList(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .toList();
    }

    public int parseAttemptCountToInt(String attemptCount) {
        return Integer.parseInt(attemptCount);
    }
}
