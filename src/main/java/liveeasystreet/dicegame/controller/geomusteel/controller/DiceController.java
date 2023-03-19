package liveeasystreet.dicegame.controller.geomusteel.controller;


import liveeasystreet.dicegame.controller.geomusteel.domain.PlayerDTO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiceController {

    @GetMapping("/jw-dice")
    public String home() {
        return "geomusteel/jw-dice";
    }

    @PostMapping("/jw-dice")
    public String dice(@Validated @ModelAttribute("playerDTO") PlayerDTO playerDTO, BindingResult bindingResult) {

        // 실패로직
        if (bindingResult.hasErrors()) {
            return "geomusteel/jw-dice";
        }

        return "geomusteel/jw-dice";
    }

}
