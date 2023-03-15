package liveeasystreet.dicegame.service.sinwonogyoon_service;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.repository.IDiceRepository;
import liveeasystreet.dicegame.service.IDiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Repository -> Service -> Controller
 * 1 ) Service는 Repository가 필요하다.
 * 2 ) Controller는 Service가 필요하다.
 * 3 ) 최대한 인터페이스를 이용하여 접근 후 해결해보기.
 */

@Service
@RequiredArgsConstructor
public class IDiceServiceImpl implements IDiceService {


    private final IDiceRepository iDiceRepository;

    @Override
    public void save(Dice dice) {
        int dice_Number = (int) (Math.random() * 6 + 1);
        dice.setNumber(dice_Number);

        DiceHistory diceHistory = iDiceRepository.findAll();
        Map<Integer, Integer> temp_repo = diceHistory.getHistory();

        Integer repo_value = temp_repo.getOrDefault(dice_Number, 0);
        temp_repo.put(dice_Number, repo_value++);
    }


    @Override
    public DiceHistory loadHistory() {
        return iDiceRepository.findAll();
    }
} //End class
