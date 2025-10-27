package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private final int tryCount;

    public RacingGame(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    // 게임을 시도 횟수만큼 진행하는 메서드
    public void startRace() {
        for (int i = 0; i < tryCount; i++) {
            System.out.println("차수 " + (i + 1));
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.getPositionDisplay());
            }
            System.out.println();
        }
    }

    // 우승자를 결정하는 메서드
    public String findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return String.join(", ", winners);
    }
}