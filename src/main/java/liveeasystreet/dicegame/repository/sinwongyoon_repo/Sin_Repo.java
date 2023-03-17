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
    // Repositor는 레퍼지토리 그 자체이다.
    // 때문에 주입 받아야 할 대상이 없다.

    // save에 의해 repo로 값이 전달된다.

    @Override
    public void save(DiceHistory diceHistory) {

        for (Map.Entry<Integer, Integer> entry : diceHistory.getHistory().entrySet()) {
            Integer Key = entry.getKey();
            Integer Value = entry.getValue();
            repo.put(Key, Value);
        }
        // DiceHistory 도메인의 history(Map)을 실질적 데이터 저장소 repo로 깊은 복사하는 과정
        // 원래는 putAll 메소드를 사용했지만 얕은복사
        // 때문에 순회를 돌며 값자체를 복사 한다.
        // 이때 깊은 복사이므로 repo의 주소값과 history(Map)의 주소값이 달라야한다.
        log.info("repo : {} ", repo);
    } // End save Method


    @Override
    public DiceHistory findAll() {
        DiceHistory diceHistory = new DiceHistory();
        diceHistory.setHistory(repo);
        return diceHistory;
        // 반환 타입이 DiceHistory이다.
        // DiceHistory 인스턴스 생성
        // history(Map)에 repo를 주입한다.
        // 이때 주의해야할 점이 DiecHistory 도메인의 history(Map)은 선언만 되어있고 초기화가 되어 있지 않다.
        // 때문에 이 과정을 거치지 않으면 NullPointerException이 발생
        // 주소값을 초기화 해준 DiceHistory 객체 자체를 넘겨줌.
    } // End findAll Method

} // End class
