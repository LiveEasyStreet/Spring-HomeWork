package liveeasystreet.dicegame.controller.yumi94;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.service.IDiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Controller를 지정해주기 위한 어노테이션에 @Controller와 @RestController가 있다고 함
 * 둘 다 많이 사용한 것은 아니라 차이점을 잘 몰랐지만 찾아보니,
 * @Controller를 가장 많이 사용하며, 주로 View를 반환할 때 사용. @ResponseBody와 함께
 * 사용 시, RestController와 같은 기능을 수행할 수 있다고 함.
 * @RestController는 JSON/XML형태로 객체 데이터 반환을 목적으로 한다고 함.
 */
@Slf4j
@Controller
@RequiredArgsConstructor             // 자동으로 생성자를 정의
public class Yumi94_DiceController {

    private final IDiceService diceService;

    @GetMapping("/yumi94")
    public String diceMain() {

        return "yumi94/startDice";

    }

    @GetMapping ("/yumi94/yumidice")
    public String yumiDice (Model model) {

        Dice yumiDice = new Dice();
        DiceHistory diceHistory = new DiceHistory();

        int randomNum = (int)(Math.random()*6)+1;
        yumiDice.setNumber(randomNum);

        model.addAttribute( "yumiDice", yumiDice);

        diceService.save(yumiDice);

        DiceHistory storagediceHistory = diceService.loadHistory();
        model.addAttribute("diceHistory", storagediceHistory);

        return "yumi94/rolldice";
    }
}
