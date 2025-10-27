package racingcar.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.RoundResultDto;

public class RacingGame {

    private Cars cars;
    private int attemptCount;
    private List<RoundResultDto> roundResults = new ArrayList<>();

    public RacingGame(List<String> carNames, int attemptCount) {
        this.cars = new Cars(carNames);
        this.attemptCount = attemptCount;
    }

    public void start() {
        while (attemptCount > 0) {
            cars.moveAndStop();
            roundResults.add(new RoundResultDto(getSnapshot()));

            attemptCount--;
        }
    }

    private Map<String, Integer> getSnapshot() {
        List<Car> currentCars = cars.getCurrentStateOfCars();
        return currentCars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getMoveCount
                        , (a, b) -> a, LinkedHashMap::new));
    }

    public List<RoundResultDto> getRoundResults() {
        return roundResults;
    }

    public List<String> getWinners() {
        List<Car> winners = cars.findWinner();
        return winners.stream().map(Car::getName)
                .collect(Collectors.toList());
    }
}
