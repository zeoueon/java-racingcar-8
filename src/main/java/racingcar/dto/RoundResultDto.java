package racingcar.dto;

import java.util.Map;

public class RoundResultDto {

    private final Map<String, Integer> roundResult;

    public RoundResultDto(Map<String, Integer> roundResult) {
        this.roundResult = roundResult;
    }

    public Map<String, Integer> getRoundResult() {
        return roundResult;
    }
}
