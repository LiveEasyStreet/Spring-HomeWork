package liveeasystreet.dicegame.controller.yerim22;


import liveeasystreet.dicegame.domain.Dice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class yerimDiceController {

    @GetMapping("/yrDice")

    public String dice (Model model) {
        // controller에서 생성된 데이터를 뷰로 전달하기 위해 model 객체 사용


        Dice dice = new Dice();

        int DiceNumber = (int)(Math.random()*6)+1;
        int diceNum = DiceNumber;

        model.addAttribute( "diceNumber", DiceNumber);


        return "yerim22/yrDice";
    }

}
