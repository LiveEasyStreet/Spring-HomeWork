package liveeasystreet.dicegame.repository.mulmer663;

import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.repository.IDiceRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SonDiceRepositoryImp implements IDiceRepository {

    private static final Map<Integer, Integer> store = new HashMap<>();

    @Override
    public void save(DiceHistory diceHistory) {
       store.putAll(diceHistory.getHistory());
    }

    @Override
    public DiceHistory findAll() {
        DiceHistory diceHistory = new DiceHistory();
        diceHistory.setHistory(store);

        return diceHistory;
    }
}
