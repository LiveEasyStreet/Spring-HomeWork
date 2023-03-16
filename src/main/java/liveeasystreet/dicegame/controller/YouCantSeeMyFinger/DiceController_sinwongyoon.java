package liveeasystreet.dicegame.controller.YouCantSeeMyFinger;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.service.IDiceService;
import liveeasystreet.dicegame.service.sinwonogyoon_service.wongyoon_diceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Repository -> Service -> Controller
 *
 * 1 ) Service는 Repository가 필요하다.
 * 2 ) Controller는 Service가 필요하다.
 * 개발 순서 : Controller ==> Repository ==> Service
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class DiceController_sinwongyoon {

    private final wongyoon_diceService diceService;
    // 컨트롤러는 서비스가 필요하다.
    // 생성자 주입

    @GetMapping("/sin")
    public String diceNumber1() {
        log.info("컨트롤러 :: diceNumber1 invoked");
        return "YouCantSeeMyFinger/Dice_number";
    }
    // 개발 의도 :
    // 시작하기 버튼을 눌러야지만 숫자 뽑기

    @PostMapping("/sin/dice_number")
    public String diceNumber2(Model model) {
        log.info("컨트롤러 :: diceNumber2 invoked");

        Dice wongyoon_Dice = new Dice();
        // 1 ) Dice 객체 생성

        DiceHistory diceHistory = new DiceHistory();
        // 2 ) DiceHistory의 history(Map)을 사용하기 위해 객체 생성

        int diceNumber = (int) (Math.random() * 6 + 1);
        // 3 ) 주사위 번호 뽑기

        wongyoon_Dice.setNumber(diceNumber);
        // 4 ) Dice 객체에 number값 설정

        diceService.save(wongyoon_Dice);
        // 5 )
        // DiceHistory의 도메인을 사용하도록 요구받음
        // private static final Map<Integer, Integer> repo = new HashMap<>();
        // 위의 repo가 실질적 데이터 저장소이다. ( 때문에 Repository의 save메소드에서 diceHistory의 Map을 repo로 복사하는 과정을 거친다.)

        model.addAttribute("dice_num", wongyoon_Dice);
        DiceHistory savedDiceHistory = diceService.loadHistory();
        model.addAttribute("diceHistory", savedDiceHistory);

        return "YouCantSeeMyFinger/Dice_Number2";
    }
}
