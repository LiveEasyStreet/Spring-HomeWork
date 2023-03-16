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
        log.info("서비스 :: Save invoked");
        Integer Dice_number = dice.getNumber();
        DiceHistory diceHistory = new DiceHistory();

        Map<Integer, Integer> map = new HashMap<>();
        diceHistory.setHistory(map);

        log.info("DiceHistory Map에 Data 주입완료");

        Integer dice_count = diceHistory.getHistory().getOrDefault(Dice_number, 0);
        diceHistory.getHistory().put(Dice_number, dice_count + 1);
        diceRepo.save(diceHistory);
        log.info("여기까지");

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
