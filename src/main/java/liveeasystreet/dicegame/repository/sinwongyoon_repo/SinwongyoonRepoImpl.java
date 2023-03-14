package liveeasystreet.dicegame.repository.sinwongyoon_repo;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.repository.IDiceRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class SinwongyoonRepoImpl implements IDiceRepository {
    /**
     * 저장 기능 메소드
     * <p>각 숫자가 몇 번 나왔는지 저장한다.</p>
     * <p>Map구조의 매개변수를 그대로 리포지토리 필드 Map에 반영하면 된다.</p>
     */
    private static final Map<Integer, Integer> repo = new HashMap<>();
    private Integer sequence = 0;

    // 1 ) static을 사용하는 이유는 이 저장소를 어디서든 불러와야하기 때문이다.
    @Override
    public void save(DiceHistory diceHistory) {
        this.sequence = this.sequence + 1;
        SinwongyoonRepoImpl.repo.put(sequence, diceHistory.getHistory().get(sequence));
    }

    /**
     * 조회 기능 메소드
     * <p>각 숫자가 몇 번 나왔는지 조회하는 메소드</p>
     * <p>엄청 간단하겠지?</p>
     */
    @Override
    public DiceHistory findAll() {
        return null;
    }
}
