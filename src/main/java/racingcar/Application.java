package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String[] carNames = inputCarNames();
        int tryCount = inputTryCount();

        RacingGame racingGame = new RacingGame(createCars(carNames), tryCount);
        racingGame.startRace();

        System.out.println("최종 우승자 : " + racingGame.findWinners());
    }

    /**
     * 자동차 이름을 입력받고 유효성 검사를 수행한 후 배열로 반환한다.
     */
    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        return validateCarNames(inputNames);
    }

    /**
     * 입력된 자동차 이름의 유효성 검사를 수행한다.
     */
    public static String[] validateCarNames(String input) {
        String[] carNames = input.split(",");
        if (carNames.length < 1) {
            throw new IllegalArgumentException("자동차 이름을 한 개 이상 입력해야 합니다.");
        }

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. : " + name);
            }
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
            }
        }
        return carNames;
    }

    /**
     * 시도할 횟수를 입력받고 유효성 검사를 수행한 후 반환한다.
     */
    public static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return validateTryCount(input);
    }

    /**
     * 입력된 시도 횟수의 유효성 검사를 수행한다.
     */
    public static int validateTryCount(String input) {
        try {
            int tryCount = Integer.parseInt(input);
            if (tryCount <= 0) {
                throw new IllegalArgumentException("횟수는 1 이상이어야 합니다.");
            }
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }

    // Car 객체를 생성하는 메서드
    public static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
