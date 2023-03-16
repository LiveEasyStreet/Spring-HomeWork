package liveeasystreet.dicegame.service.sinwonogyoon_service;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.DiceHistory;

public interface wongyoon_diceService {
    /**
     * 각 숫자별 나온 횟수를 기록하는 메소드
     * <p>매개변수로는 주사위만 받고 리포지토리의 findAll 메소드 호출 할 것</p>
     * <p>핵심로직 부분이므로 여기서 1 : 0번, 2 : 1번, 3 : 4번 ... 이런 식의 구조를 완성시켜야함</p>
     * <p>로직 구현 하고 리포지토리의 save 메소드를 호출할 것</p>
     */
    void save(Dice dice);

    /**
     * 숫자별 나온 횟수를 가져오는 메소드
     * <p>엄청 간단함</p>
     */
    DiceHistory loadHistory();

    void clear(DiceHistory diceHistory);
}
