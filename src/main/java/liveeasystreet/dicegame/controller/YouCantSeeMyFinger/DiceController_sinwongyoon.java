package liveeasystreet.dicegame.controller.YouCantSeeMyFinger;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.service.IDiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Repository -> Service -> Controller
 * 1 ) Service는 Repository가 필요하다.
 * 2 ) Controller는 Service가 필요하다.
 */

@Controller
@RequiredArgsConstructor
public class DiceController_sinwongyoon {

    private final IDiceService iDiceService;

    @GetMapping("/sin")
    public String diceNumber1() {
        return "YouCantSeeMyFinger/Dice_number";
    }

    @PostMapping("/sin/dice_number")
    public String diceNumber2(Model model) {
        Dice dice = new Dice();
        dice.setNumber((int) (Math.random() * 6 + 1));

        model.addAttribute("dice_num", dice);
        return "YouCantSeeMyFinger/dice_Number2";
    }
}
