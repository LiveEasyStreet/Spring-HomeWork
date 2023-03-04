package liveeasystreet.dicegame.controller.geomusteel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiceController {

    @GetMapping("/jw-dice")
    public String dice(){
        return "/geomusteel/dice";
    }
}
