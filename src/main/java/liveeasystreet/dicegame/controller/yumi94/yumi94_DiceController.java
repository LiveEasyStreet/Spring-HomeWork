package liveeasystreet.dicegame.controller.yumi94;

import liveeasystreet.dicegame.domain.Dice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class yumi94_DiceController {
    // @RequestMapping에 메소드로 get과 post를 넣어서도 가능하지만 그 경우, 경로가 중복되지 않아 각각의
    // 다른 경로를 사용해야 하며, 코드 또한 길어진다고 하여 GetMapping사용
    @GetMapping("/yumi_dice")

    public String dice (Model model) {
        // controller에서 생성된 데이터를 뷰로 전달하기 위해 model 객체 사용


        Dice dice = new Dice();                                 // 주사위 생성

        int randomNum = (int)(Math.random()*6)+1;               // 1~6까지의 랜덤 숫자 추출
        int diceNum = randomNum;                                //  랜덤 숫자 저장

        model.addAttribute( "diceNum", diceNum);    // 이름과 값이 diceNum인 모델 속성 추가
                                                                // 정한 이름을 통해 뷰코드에서 모델 데이터에 접근 가능

        return "yumi94/dice";
    }
}
