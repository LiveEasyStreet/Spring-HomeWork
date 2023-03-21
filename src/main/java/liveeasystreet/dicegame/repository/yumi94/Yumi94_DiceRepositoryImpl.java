package liveeasystreet.dicegame.repository.yumi94;

import liveeasystreet.dicegame.domain.DiceHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class Yumi94_DiceRepositoryImpl implements YumiIDiceRepository {

    private static final Map<Integer, Integer> yumiDiceRepository = new HashMap<>();

    @Override
    public void save(DiceHistory diceHistory) {

        Map<Integer, Integer> diceNumHistory = diceHistory.getHistory();

        for(Integer key : diceNumHistory.keySet()) {
            yumiDiceRepository.put(key, diceNumHistory.get(key));
        }
    }
    @Override
    public DiceHistory findAll() {
        DiceHistory diceHistory = new DiceHistory();
        diceHistory.setHistory(yumiDiceRepository);

        return diceHistory;
    }
}
