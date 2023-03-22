package liveeasystreet.dicegame.service.yumi94;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.repository.yumi94.YumiIDiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Map;


@Slf4j
@Service
@RequiredArgsConstructor
public class Yumi94_DiceServiceImpl implements YumiIDiceService {

    private final YumiIDiceRepository yumiDiceRepository;

    @Override
    public void save(Dice dice) {
        int number = dice.getNumber();
        DiceHistory diceHistory = yumiDiceRepository.findAll();

        Map<Integer, Integer> diceNumHistory = diceHistory.getHistory();

        if(diceNumHistory.isEmpty()) {
            for(int i= 1; i < 7; i++) {
                diceNumHistory.put(i,0);
            }
        }
        diceNumHistory.put(number, diceNumHistory.get(number)+1);
        diceHistory.setHistory(diceNumHistory);

        yumiDiceRepository.save(diceHistory);
    }

    @Override
    public DiceHistory loadHistory() {

        return yumiDiceRepository.findAll();
    }
}
