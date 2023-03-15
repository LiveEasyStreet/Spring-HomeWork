package liveeasystreet.dicegame.controller.mulmer663;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.service.IDiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Slf4j
@Controller
@RequiredArgsConstructor
public class Son_DiceController {

    private final IDiceService diceService;

    @GetMapping("son_dice")
    public String son_DiceController() {

        return "mulmer663/Son_Dice";
    }

    @ResponseBody
    @PostMapping("son_dice")
    public DiceForm makeRandomDiceNum(@RequestBody DiceForm form) {
        int randomNum = new Random().nextInt(6) + 1;
        form.setNumber(randomNum);
//        log.info("dice = {}", dice.getNumber());

        Dice dice = new Dice();
        dice.setNumber(form.getNumber());
        diceService.save(dice);

        form.setHistory(diceService.loadHistory().getHistory());
        return form;
    }

}
