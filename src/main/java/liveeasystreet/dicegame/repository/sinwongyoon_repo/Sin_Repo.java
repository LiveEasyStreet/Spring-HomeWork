package liveeasystreet.dicegame.repository.sinwongyoon_repo;

import liveeasystreet.dicegame.domain.DiceHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class Sin_Repo implements wongyoon_diceRepo {

    private static final Map<Integer, Integer> repo = new HashMap<>();

    @Override
    public void save(DiceHistory diceHistory) {

        for (Map.Entry<Integer, Integer> entry : diceHistory.getHistory().entrySet()) {
            Integer Key = entry.getKey();
            Integer Value = entry.getValue();
            repo.put(Key, Value);
        }
        // DiceHistory => history라는 Map에 저장되어있는 Key , Value 값을 repo로 복사 및 붙여넣기 작업
        // 때문에 우선 DiceHistory의 Map에 데이터를 저장시켜놓고 save메소드를 호출시키도록하자
        log.info("repo : {} ", repo);
    } // End save Method


    @Override
    public DiceHistory findAll() {
        DiceHistory diceHistory = new DiceHistory();
        diceHistory.setHistory(repo);

        return diceHistory;
    } // End findAll Method

} // End class
