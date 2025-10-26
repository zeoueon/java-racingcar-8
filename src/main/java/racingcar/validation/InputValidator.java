package racingcar.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorMessage;

public class InputValidator {

    public void validateCarNames(String carNames) {
        String[] carNamesList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .toArray(String[]::new);

        for (String carName : carNamesList) {
            checkNameLength(carName);
        }

        checkDuplicateCarNames(carNamesList);
    }

    public void validateAttemptCount(String attemptCount) {
        try {
            checkNonNegativeInteger(Integer.parseInt(attemptCount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_TYPE);
        }
    }

    private void checkNonNegativeInteger(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPT_COUNT);
        }
    }

    private void checkNameLength(String carNames) {
        if (carNames.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
        }
    }

    private void checkDuplicateCarNames(String[] carNamesList) {
        List<String> duplicateCarNameList = Arrays.asList(carNamesList);
        Set<String> duplicateCarNameSet = new HashSet<>(duplicateCarNameList);

        if (duplicateCarNameList.size() != duplicateCarNameSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATE_CAR_NAMES);
        }
    }
}
