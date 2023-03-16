package liveeasystreet.dicegame.controller.chansol08;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.service.chansol8.IChansolDiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
@RequiredArgsConstructor
public class ChansDiceController {

    private final IChansolDiceService service;

    @GetMapping("/chans_dice")
    public String MyDice(Model model) {

        Dice myDice = new Dice();
        Random rd = new Random();

        myDice.setNumber(rd.nextInt(6) + 1);
        model.addAttribute("myDice", myDice);

        service.save(myDice);
        DiceHistory diceHistory = service.loadHistory();

        model.addAttribute("diceHistory", diceHistory);

        return "chansol08/chans_dice";
    }
}
