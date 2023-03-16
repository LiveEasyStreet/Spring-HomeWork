package liveeasystreet.dicegame.service.chansol8;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.repository.chansol08.IChansolDiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChansolDiceServiceImp implements IChansolDiceService {

    private final IChansolDiceRepository myRepository;

    /**
     * 각 숫자별 나온 횟수를 기록하는 메소드
     * <p>매개변수로는 주사위만 받고 리포지토리의 findAll 메소드 호출 할 것</p>
     * <p>핵심로직 부분이므로 여기서 1 : 0번, 2 : 1번, 3 : 4번 ... 이런 식의 구조를 완성시켜야함</p>
     * <p>로직 구현 하고 리포지토리의 save 메소드를 호출할 것</p>
     */
    @Override
    public void save(Dice dice) {
        DiceHistory diceHistory = myRepository.findAll();
        Map<Integer, Integer> myHistory = diceHistory.getHistory();

        if (myHistory.isEmpty()) {
            for (int i = 1; i < 7; i++) {
                myHistory.put(i, 0);
            }
        }

        int number = dice.getNumber();
        myHistory.put(number, myHistory.get(number) + 1);

        diceHistory.setHistory(myHistory);
        myRepository.save(diceHistory);
    }

    /**
     * 숫자별 나온 횟수를 가져오는 메소드
     * <p>엄청 간단함</p>
     */
    @Override
    public DiceHistory loadHistory() {
        return myRepository.findAll();
    }
}
