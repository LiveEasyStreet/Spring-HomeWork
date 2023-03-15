package liveeasystreet.dicegame.repository.sinwongyoon_repo;

import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.repository.IDiceRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Repository -> Service -> Controller
 * 1 ) Service는 Repository가 필요하다.
 * 2 ) Controller는 Service가 필요하다.
 */

@Repository
public class IDiceRepositoryImpl implements IDiceRepository {


    private static final Map<Integer, Integer> repo = new ConcurrentHashMap<>();

    @Override
    public void save(DiceHistory diceHistory) {
        for (Map.Entry<Integer, Integer> entry : repo.entrySet()) {
            diceHistory.getHistory().put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public DiceHistory findAll() {
        DiceHistory diceHistory = new DiceHistory();
        this.save(diceHistory);
        return diceHistory;
    }
}
