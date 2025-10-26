package racingcar.converter;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public List<String> parseCarNamesToList(String carNames) {
        List<String> carNamesList = Arrays.asList(carNames.split(","));

        for (String carName : carNamesList) {
            carName = carName.trim();
        }

        return carNamesList;
    }

    public int parseAttemptCountToInt(String attemptCount) {
        return Integer.parseInt(attemptCount);
    }
}
