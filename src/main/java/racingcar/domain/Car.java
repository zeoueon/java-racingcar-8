package racingcar.domain;

import java.util.function.Supplier;

public class Car {

    private String name;
    private Supplier<Integer> randomIntegerSupplier;
    private int moveCount = 0;

    public Car(String name, Supplier<Integer> randomIntegerSupplier) {
        this.name = name;
        this.randomIntegerSupplier = randomIntegerSupplier;
    }

    public boolean isMovable() {
        return randomIntegerSupplier.get() >= 4;
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

    public void setRandomIntegerSupplier(Supplier<Integer> randomIntegerSupplier) {
        this.randomIntegerSupplier = randomIntegerSupplier;
    }
}
