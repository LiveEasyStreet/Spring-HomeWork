package liveeasystreet.dicegame.controller.TaeKyoung108.controller;


import liveeasystreet.dicegame.domain.Dice;
import liveeasystreet.dicegame.domain.TK_Dice;
import liveeasystreet.dicegame.domain.TK_DiceHistory;
import liveeasystreet.dicegame.domain.TK_DiceList;
import liveeasystreet.dicegame.service.tk108.tk108_DiceServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Random;

@Slf4j
@Controller     // controller임을 알려주는 표시
@RequiredArgsConstructor
/*
@Controller와는 다르게 @RestController는 리턴값에 자동으로 @ResponseBody가 붙게되어 별도 어노테이션을 명시해주지 않아도 HTTP 응답데이터(body)에 자바 객체가 매핑되어 전달 된다.
@Controller인 경우에 바디를 자바객체로 받기 위해서는 @ResponseBody 어노테이션을 반드시 명시해주어야한다.
* */
public class tk108_DiceController {

    private final tk108_DiceServiceInterface tk108_DiceService;
    public static int last_num = 1;


    @GetMapping("/tk108_dice")
    public String tk108_dice(){
        tk108_DiceService.clearHistory();
        return "/TaeKyoung108/dice";
    }

    @ResponseBody   //  @Responsebody 어노테이션을 사용하면 http요청 body를 자바 객체로 전달받을 수 있다.
    @PostMapping("/tk108_dice")
    public TK_DiceHistory makeRandomDiceNum(@RequestBody TK_Dice dice) {
        /*
        @RequestBody
        이 어노테이션이 붙은 파라미터에는 http요청의 본문(body)이 그대로 전달된다.
        일반적인 GET/POST의 요청 파라미터라면 @RequestBody를 사용할 일이 없을 것이다.
        반면에 xml이나 json기반의 메시지를 사용하는 요청의 경우에 이 방법이 매우 유용하다.
        HTTP 요청의 바디내용을 통째로 자바객체로 변환해서 매핑된 메소드 파라미터로 전달해준다.

        대충 결론 : requestbody는 xml, json 등을 객체로, responsebody는 받을 데이터를 자바 객체에서 json 등으로 바꿔준다
    */
        if(dice.getNumber()[0]==0){
            int[] rand5 = new int[5];

            for(int i=0;i<rand5.length;i++){
                rand5[i]= new Random().nextInt(6) + 1;
            }
            Arrays.sort(rand5);
            TK_Dice new_dice = new TK_Dice();
            new_dice.setNumber(rand5);
            tk108_DiceService.save_temp(new_dice);
            TK_DiceHistory temp_history = tk108_DiceService.findAll();
            return temp_history;
        }
        else {
            tk108_DiceService.save(dice);
            TK_DiceHistory temp_history = tk108_DiceService.findAll();
            return temp_history;
        }
    }

//    @ResponseBody   //  @Responsebody 어노테이션을 사용하면 http요청 body를 자바 객체로 전달받을 수 있다.
//    @PostMapping("/tk108_dice")
//    public TK_Dice makeRandomDiceNum(@RequestBody TK_Dice dice ) {
//        System.out.println(dice.getNumber()[0]);
//        /*
//        @RequestBody
//        이 어노테이션이 붙은 파라미터에는 http요청의 본문(body)이 그대로 전달된다.
//        일반적인 GET/POST의 요청 파라미터라면 @RequestBody를 사용할 일이 없을 것이다.
//        반면에 xml이나 json기반의 메시지를 사용하는 요청의 경우에 이 방법이 매우 유용하다.
//        HTTP 요청의 바디내용을 통째로 자바객체로 변환해서 매핑된 메소드 파라미터로 전달해준다.
//
//        대충 결론 : requestbody는 xml, json 등을 객체로, responsebody는 받을 데이터를 자바 객체에서 json 등으로 바꿔준다
//    */
//        int[] rand5 = new int[5];
//        int rand = new Random().nextInt(6) + 1;
//
//        for(int i=0;i<rand5.length;i++){
//            rand5[i]= new Random().nextInt(6) + 1;
//        }
//        Arrays.sort(rand5);
//        dice.setNumber(rand5);
//        return dice;
//    }
}