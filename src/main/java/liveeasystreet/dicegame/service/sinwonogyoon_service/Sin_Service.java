package liveeasystreet.dicegame.service.sinwonogyoon_service;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.repository.sinwongyoon_repo.wongyoon_diceRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class Sin_Service implements wongyoon_diceService {

    private final wongyoon_diceRepo diceRepo;

    @Override
    public void save(Dice dice) {
        log.info("");
        Integer Dice_number = dice.getNumber();
        DiceHistory diceHistory = diceRepo.findAll();
        // 레포 다시 확인

        Map<Integer, Integer> history = diceHistory.getHistory();

        if (!history.containsKey(1) && !history.containsKey(6)) {
            for (int i = 1; i <= 6; i++) {
                history.put(i, 0);
            }
        }

        Integer dice_count = history.getOrDefault(Dice_number, 0);
        history.put(Dice_number, dice_count + 1);
        log.info("diceHistory : {}",diceHistory);

        diceRepo.save(diceHistory);
        // 문제발생 1 :
        // NullPointerException 발생
        //
        // 문제 발생 이유 :
        // 가정 1 ) DiceHistory의 Map은 선언만 되어있고 초기화가 되어있지 않다. 즉 , Map Refference를 연결시켜줘야한다.

        // 해결 방안 :
        // 1) map 레퍼런스를 주입 (완료)

    }


    @Override
    public DiceHistory loadHistory() {
        return diceRepo.findAll();
    }
}
