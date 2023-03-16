package liveeasystreet.dicegame.repository.chansol08;

import liveeasystreet.dicegame.domain.DiceHistory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ChansolDiceRepositoryImp implements IChansolDiceRepository {

    private static final Map<Integer, Integer> myRepository = new HashMap<>();

    @Override
    public void save(DiceHistory diceHistory) {

        Map<Integer, Integer> history = diceHistory.getHistory();

        for (Integer key : history.keySet()) {
            myRepository.put(key, history.get(key));
        }
    }

    @Override
    public DiceHistory findAll() {
        DiceHistory diceHistory = new DiceHistory();
        diceHistory.setHistory(myRepository);

        return diceHistory;
    }
}
