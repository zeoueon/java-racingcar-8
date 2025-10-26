package racingcar.domain;

import racingcar.util.RandomIntegerGenerator;

public class Car {

    private String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public boolean isMovable() {
        return RandomIntegerGenerator.getRandomNumber() >= 4;
    }

    public void move() {
        moveCount++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
