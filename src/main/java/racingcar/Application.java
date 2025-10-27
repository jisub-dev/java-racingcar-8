package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // 자동차 이름 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        String[] carNames = inputCarNames(inputNames);

        // 시도 횟수 입력 받기
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = inputTryCount();

        // 출력: 정상적으로 입력받았는지 확인
        System.out.println("자동차 이름: " + String.join(", ", carNames));
        System.out.println("시도 횟수: " + tryCount);
    }

    /**
     * 자동차 이름을 입력받고 유효성 검사를 수행한 후 배열로 반환한다.
     */
    public static String[] inputCarNames(String input) {
        String[] carNames = input.split(",");
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return carNames;
    }

    /**
     * 시도할 횟수를 입력받고 유효성 검사를 수행한 후 반환한다.
     */
    public static int inputTryCount() {
        String input = Console.readLine();
        try {
            int tryCount = Integer.parseInt(input);
            if (tryCount <= 0) {
                throw new IllegalArgumentException("횟수는 1 이상이어야 합니다.");
            }
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}