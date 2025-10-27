package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        createCars(carNames);
    }

    private void createCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
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

    public List<Car> findWinner() {
        return cars.stream().filter(
                car -> car.getMoveCount() == getMaxMoveCount()).toList();
    }

    private int getMaxMoveCount() {
        return cars.stream().mapToInt(Car::getMoveCount)
                .max().orElse(0);
    }
}
