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
    /*
     * Repository -> Service -> Controller
     * */
    private final wongyoon_diceRepo diceRepo;
    // 서비스는 레퍼지토리를 주입받아야한다.
    // @RequiredArgsConstructor에 의해 diceRepo는 생성자의 파라미터로 들어가고 초기화된다.
    // 이때 생성자가 한 개라면 @AutoWired가 붙는다.
    // 때문에 컨테이너에서 자동 주입해준다.

    @Override
    public void save(Dice dice) {
        log.info("서비스 :: save invoked");
        // 1 ) save의 파라미터 => dice
        // dice 객체는 컨트롤러에서 숫자 설정이 되고 넘어온다.


        Integer Dice_number = dice.getNumber();
        DiceHistory diceHistory = diceRepo.findAll();
        // Repository의 findAll 주석 참고
        // 때문에 repo주소를 갖고있는 DiceHistory객체 자체를 연결

        // 수정 전 코드
        // DiceHistory diceHistory = new DiceHistory();
        // Map<Integer , Integer> repo = new Map<>();
        // diceHistory.set(repo);
        // 이렇게 코드를 작성하면 repo의 value (count가 제대로 올라가지 않는다.)

        Map<Integer, Integer> history = diceHistory.getHistory();

        if (!history.containsKey(1) && !history.containsKey(6)) {
            for (int i = 1; i <= 6; i++) {
                history.put(i, 0);
            }
        }
        // history에 키 => 1 , 6이 저장 되어있지 않으면 history 초기화

        Integer dice_count = history.getOrDefault(Dice_number, 0);
        history.put(Dice_number, dice_count + 1);
    }


    @Override
    public DiceHistory loadHistory() {
        log.info("서비스 :: loadHistory invoked");
        return diceRepo.findAll();
    }

    @Override
    public void clear(DiceHistory diceHistory) {
        log.info("서비스 :: clear invoked");
        diceHistory.getHistory().clear();
    }

}
