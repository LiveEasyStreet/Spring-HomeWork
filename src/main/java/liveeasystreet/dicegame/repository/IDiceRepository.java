package liveeasystreet.dicegame.repository;

import liveeasystreet.dicegame.domain.DiceHistory;

import java.util.Map;

public interface IDiceRepository {

    /**
     * 저장 기능 메소드
     * <p>각 숫자가 몇 번 나왔는지 저장한다.</p>
     * <p>Map구조의 매개변수를 받아 그래도 리포지토리 필드 Map에 반영하면 된다.</p>
     */
    void save(DiceHistory diceHistory);

    /**
     * 조회 기능 메소드
     * <p>각 숫자가 몇 번 나왔는지 조회하는 메소드</p>
     * <p>엄청 간단하겠지?</p>
     */
   DiceHistory findAll();
}
