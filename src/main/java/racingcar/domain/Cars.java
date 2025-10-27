package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomIntegerGenerator;

public class Cars {

    public List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        createCars(carNames);
    }

    private void createCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName, RandomIntegerGenerator::getRandomNumber));
        }
    }

    public void moveAndStop() {
        for (Car car : cars) {
            moveIfPossible(car);
        }
    }

    private void moveIfPossible(Car car) {
        if (car.isMovable()) {
            car.move();
        }
    }

    public List<Car> getCurrentStateOfCars() {
        return cars.stream().toList();
    }

    public List<String> findWinner() {
        return cars.stream().filter(
                        car -> car.getMoveCount() == getMaxMoveCount())
                .map(Car::getName)
                .toList();
    }

    private int getMaxMoveCount() {
        return cars.stream().mapToInt(Car::getMoveCount)
                .max().orElse(0);
    }
}
