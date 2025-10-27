package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingCarTest {

    Supplier<Integer> movableSupplier = () -> 9;
    Supplier<Integer> stopSupplier = () -> 0;

    @Test
    void 자동차_전진_테스트() {
        //given
        Car car = new Car("aaa", movableSupplier);
        Car car2 = new Car("bbb", stopSupplier);

        //when
        if (car.isMovable()) {
            car.move();
        }
        if (car2.isMovable()) {
            car2.move();
        }

        //then
        assertThat(car.getMoveCount()).isEqualTo(1);
        assertThat(car2.getMoveCount()).isEqualTo(0);
    }

    @Test
    void 복수_우승자_테스트() {
        //given
        Cars cars = new Cars(List.of("aaa", "bbb", "ccc"));
        for (Car car : cars.cars) {
            car.setRandomIntegerSupplier(movableSupplier);
        }

        //when
        cars.moveAndStop();

        //then
        assertThat(cars.findWinner()).isEqualTo(List.of("aaa", "bbb", "ccc"));

    }
}
