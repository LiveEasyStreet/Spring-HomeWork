package liveeasystreet.dicegame.controller.geomusteel.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Player {

    private List<Integer> diceHistory = new ArrayList<>();

    private String name;
    private int diceNumber = 0;
    private int totalScore = 0;

    // 기본 생성자
    public Player() {
    }

    // 이름 생성자
    public Player(String name) {
        this.name = name;
    }

    // 모든 생성자
    public Player(String name, int diceNumber) {
        this.name = name;
        this.diceNumber = diceNumber;
    }




}
