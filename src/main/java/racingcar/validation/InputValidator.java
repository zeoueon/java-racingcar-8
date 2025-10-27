package racingcar.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorMessage;

public class InputValidator {

    public void validateCarNames(String carNames) {
        List<String> carNamesList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .toList();

        for (String carName : carNamesList) {
            checkNameLength(carName);
        }

        checkCarNamesCount(carNamesList);
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

    private void checkDuplicateCarNames(List<String> carNamesList) {
        Set<String> duplicateCarNameSet = new HashSet<>(carNamesList);

        if (carNamesList.size() != duplicateCarNameSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATE_CAR_NAMES);
        }
    }

    private void checkCarNamesCount(List<String> carNamesList) {
        if (carNamesList.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_CAR_COUNT);
        }
    }
}
