package liveeasystreet.dicegame.controller.YouCantSeeMyFinger;

import liveeasystreet.dicegame.domain.Dice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DiceController_sinwongyoon {

    @GetMapping(value = "/Dice_number")
    public String roll(Model model) {

        Dice dice = new Dice();

        int Dice_number;
        // 랜덤숫자 1부터 6까지 임시 저장
        Dice_number = (int) (Math.random() * 6 + 1);
        // 저장완료
        dice.setNumber(Dice_number);
        // setter 이용하여 값 넣기
        model.addAttribute("DiceNumber", dice);
        // 타임리프문을 사용하여 객체의 값 출력
        // ex ) ${DiceNumber.number}
        // domain사용

        return "YouCantSeeMyFinger/Dice_number";
    }
}
