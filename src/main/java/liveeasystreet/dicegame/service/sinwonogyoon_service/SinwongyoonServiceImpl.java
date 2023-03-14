package liveeasystreet.dicegame.service.sinwonogyoon_service;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.service.IDiceService;
import org.springframework.stereotype.Service;


@Service
public class SinwongyoonServiceImpl implements IDiceService {
    @Override
    public void save(Dice dice, DiceHistory diceHistory) {
        //대입은 여기서
    }

    @Override
    public DiceHistory loadHistory() {
        return null;
    }
}
