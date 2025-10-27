package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    // 전진 조건: 0~9 사이의 랜덤 값이 4 이상이면 전진
    public void move() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            position++;
        }
    }

    // 자동차 이름 반환
    public String getName() {
        return name;
    }

    // 자동차 현재 위치 반환
    public int getPosition() {
        return position;
    }

    // 현재 위치를 '-'로 표시하는 메서드
    public String getPositionDisplay() {
        return "-".repeat(position);
    }
}

