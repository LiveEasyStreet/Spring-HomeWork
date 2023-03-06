package liveeasystreet.dicegame.controller.mulmer663;

import liveeasystreet.dicegame.domain.Dice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Slf4j
@Controller
public class Son_DiceController {

    @GetMapping("son_dice")
    public String son_DiceController() {
        return "mulmer663/Son_Dice";
    }

    @ResponseBody
    @PostMapping("son_dice")
    public Dice makeRandomDiceNum(@RequestBody Dice dice) {
        int randomNum = new Random().nextInt(6) + 1;
        dice.setNumber(randomNum);
//        log.info("dice = {}", dice.getNumber());

        return dice;
    }

}
