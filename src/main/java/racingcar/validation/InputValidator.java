package racingcar.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public void validateCarNames(String carNames) {
        String[] carNamesList = carNames.split(",");

        for (String carName : carNamesList) {
            carName = carName.trim();
            checkNameLength(carName);
        }

        checkDuplicateCarNames(carNamesList);
    }

    public void validateAttemptCount(String attemptCount) {
        try {
            checkNonNegativeInteger(Integer.parseInt(attemptCount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNonNegativeInteger(int attemptCount) {
        if (attemptCount < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNameLength(String carNames) {
        if (carNames.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateCarNames(String[] carNamesList) {
        List<String> duplicateCarNameList = Arrays.asList(carNamesList);
        Set<String> duplicateCarNameSet = new HashSet<>(duplicateCarNameList);

        if (duplicateCarNameList.size() != duplicateCarNameSet.size()) {
            throw new IllegalArgumentException();
        }
    }
}
