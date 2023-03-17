package liveeasystreet.dicegame.repository.sinwongyoon_repo;

import liveeasystreet.dicegame.domain.DiceHistory;

public interface wongyoon_diceRepo {

    /**
     * 저장 기능 메소드
     * <p>각 숫자가 몇 번 나왔는지 저장한다.</p>
     * <p>diceHistory 매개변수를 받아 깊은 복사로 리포지토리 필드 Map에 반영하면 된다.</p>
     */
    void save(DiceHistory diceHistory);

    /**
     * 조회 기능 메소드
     * <p>각 숫자가 몇 번 나왔는지 조회하는 메소드</p>
     * <p>엄청 간단하겠지?</p>
     */
   DiceHistory findAll();
}
