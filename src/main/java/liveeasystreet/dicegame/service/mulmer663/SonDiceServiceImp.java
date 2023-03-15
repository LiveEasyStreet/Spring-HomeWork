package liveeasystreet.dicegame.service.mulmer663;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.repository.IDiceRepository;
import liveeasystreet.dicegame.service.IDiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SonDiceServiceImp implements IDiceService {

    private final IDiceRepository diceRepository;

    @Override
    public void save(Dice dice) {
        int number = dice.getNumber();
        DiceHistory diceHistory = diceRepository.findAll();
        Map<Integer, Integer> history = diceHistory.getHistory();

        // 1: 0번, 2: 0번 ... 의 구조를 만들어주는 초기화 코드
        if (!history.containsKey(1) && !history.containsKey(6)) {
            for (int i = 1; i <= 6; i++) {
                history.put(i, 0);
            }
        }

        history.put(number, history.getOrDefault(number, 0) + 1);

        diceRepository.save(diceHistory);
    }

    @Override
    public DiceHistory loadHistory() {
        return diceRepository.findAll();
    }
}
