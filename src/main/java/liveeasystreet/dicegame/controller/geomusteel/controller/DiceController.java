package liveeasystreet.dicegame.controller.geomusteel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/jw-dice")
    public String dice(Model model) {

        // ** 숫자를 직접 넣어서 하는 방법 시작 ** //
        // Random 클래스를 사용해서 랜덤번호 생성 //
        Random random = new Random();
        int diceNumber = random.nextInt(6) + 1;


        // 모델에 생성된 번호 저장 //
        model.addAttribute("diceNumber", diceNumber);
        // ** 숫자를 직접 넣어서 하는 방법 종료 ** //

        // ** 폰트 어썸 아이콘 클래스명으로 치환해서 넣는 방법 시작 ** //
        String diceClass = "";
        switch (diceNumber) {
            case 1: diceClass = "fa-solid fa-dice-one"; break;
            case 2: diceClass = "fa-solid fa-dice-two"; break;
            case 3: diceClass = "fa-solid fa-dice-three"; break;
            case 4: diceClass = "fa-solid fa-dice-four"; break;
            case 5: diceClass = "fa-solid fa-dice-five"; break;
            case 6: diceClass = "fa-solid fa-dice-six"; break;
        }
        model.addAttribute("diceClass", diceClass);
        // ** 폰트 어썸 아이콘 클래스명으로 치환해서 넣는 방법 종료 ** //

        return "geomusteel/jw-dice";
    }

}
