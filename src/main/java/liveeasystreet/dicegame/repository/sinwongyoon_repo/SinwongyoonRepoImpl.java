package liveeasystreet.dicegame.repository.sinwongyoon_repo;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.repository.IDiceRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class SinwongyoonRepoImpl implements IDiceRepository {

    private static final Map<Integer, Integer> repo = new HashMap<>();
    private Integer sequence = 0;

    // 1 ) static을 사용하는 이유는 이 저장소를 어디서든 불러와야하기 때문이다.
    @Override
    public void save(DiceHistory diceHistory) {
        this.sequence = this.sequence + 1;
        SinwongyoonRepoImpl.repo.put(sequence, diceHistory.getHistory().get(sequence));
    }

    @Override
    public DiceHistory findAll() {
        return null;
    }
}
