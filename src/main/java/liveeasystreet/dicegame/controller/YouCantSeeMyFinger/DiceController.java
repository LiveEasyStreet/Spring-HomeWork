package liveeasystreet.dicegame.controller.YouCantSeeMyFinger;

import liveeasystreet.dicegame.domain.Dice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DiceController {

    public Dice dice;

    public DiceController() {
        this.dice = new Dice();
    }


    @GetMapping(value = "/Dice_number")
    public String roll(Model model) {
        int Dice_number;
        // 랜덤숫자 1부터 6까지 임시 저장
        Dice_number = (int) Math.floor((Math.random() * 6 + 1) * 10);
        // 저장완료
        this.dice.setNumber(Dice_number);
        // setter 이용하여 값 넣기
        model.addAttribute("DiceNumber", this.dice);
        // 타임리프문을 사용하여 객체의 값 출력
        // ex ) ${DiceNumber.number}

        return "Dice_number";
    }
}
