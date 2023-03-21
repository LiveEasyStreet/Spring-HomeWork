package liveeasystreet.dicegame.controller.yumi94;

import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.service.IDiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// 오류 때문에 헷갈리기 시작해서 내래 주석을 달아봅니다.


/**
 * Controller를 지정해주기 위한 어노테이션에 @Controller와 @RestController가 있다고 함
 * 둘 다 많이 사용한 것은 아니라 차이점을 잘 몰랐지만 찾아보니,
 * @Controller를 가장 많이 사용하며, 주로 View를 반환할 때 사용. @ResponseBody와 함께
 * 사용 시, RestController와 같은 기능을 수행할 수 있다고 함.
 * @RestController는 JSON/XML형태로 객체 데이터 반환을 목적으로 한다고 함.
 */
@Slf4j
@Controller
@RequiredArgsConstructor             // 자동으로 생성자를 정의
public class Yumi94_DiceController {

    private final IDiceService diceService;

    @GetMapping("/yumi_dice")                                        // yumi_dice로 Get요청이 들어오면 return 값인 "yumi94/dice"을 생성?
    public String diceMain() {

        return "yumi94/yumiDice";
    }

    @PostMapping("/yumi_dice")                                       // 저번 코드에서 해당 주소를 열면 바로 주사위 숫자가 나오는 이유가
                                                                    // GetMapping만 존재하고 PostMapping을 사용하지 않았기 때문이다.
    public String yumiDice (Model model) {

        Dice yumiDice = new Dice();                                 // yumiDice 객체 생성
        DiceHistory diceHistory = new DiceHistory();

        int randomNum = (int)(Math.random()*6)+1;                   // 주사위 랜덤숫자 생성과 yumiDice에 보관
        yumiDice.setNumber(randomNum);

        model.addAttribute( "yumiDice", yumiDice);      // yumiDice 객체를 "yumiDice"이름으로 추가

        diceService.save(yumiDice);

        DiceHistory storagediceHistory = diceService.loadHistory();
        model.addAttribute("diceHistory", storagediceHistory); //

        return "yumi94/yumiDice";
    }
}
