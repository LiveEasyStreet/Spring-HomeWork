package liveeasystreet.dicegame.controller.YouCantSeeMyFinger;

import liveeasystreet.dicegame.domain.Dice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DiceController_sinwongyoon {


    @GetMapping("/sin")
    public String first_page() {
        return "YouCantSeeMyFinger/Dice_number";
    }

    @PostMapping("/sin/dice_number")
    public String diceNumber(Model model) {
        Dice dice = new Dice();
        dice.setNumber((int) (Math.random() * 6 + 1));

        model.addAttribute("dice_num", dice);
        return "YouCantSeeMyFinger/dice_Number2";
    }
}
