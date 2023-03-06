package liveeasystreet.dicegame.controller.mulmer663;

import liveeasystreet.dicegame.domain.Dice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class Son_DiceController {

    @GetMapping("son_dice")
    public String son_DiceController(Model model) {
        Dice dice = new Dice();
        int randomNum = new Random().nextInt(6);

        dice.setNumber(randomNum);
        model.addAttribute("dice", dice);

        return "mulmer663/Son_Dice";
    }
}
