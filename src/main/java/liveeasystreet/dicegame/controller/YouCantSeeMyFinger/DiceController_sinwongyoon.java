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
 * 1 ) Service는 Repository가 필요하다.
 * 2 ) Controller는 Service가 필요하다.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class DiceController_sinwongyoon {

    private final wongyoon_diceService diceService;

    @GetMapping("/sin")
    public String diceNumber1() {
        return "YouCantSeeMyFinger/Dice_number";
    }

    @PostMapping("/sin/dice_number")
    public String diceNumber2(Model model) {
        log.info("컨트롤러 diceNumber2 :: invoked");

        Dice wongyoon_Dice = new Dice();
        DiceHistory diceHistory = new DiceHistory();

        int diceNumber = (int) (Math.random() * 6 + 1);
        wongyoon_Dice.setNumber(diceNumber);

        diceService.save(wongyoon_Dice);

        model.addAttribute("dice_num", wongyoon_Dice);

        DiceHistory savedDiceHistory = diceService.loadHistory();
        model.addAttribute("diceHistory", savedDiceHistory);

        return "YouCantSeeMyFinger/Dice_Number2";
    }
}
