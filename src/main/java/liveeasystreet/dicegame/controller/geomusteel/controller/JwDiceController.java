package liveeasystreet.dicegame.controller.geomusteel.controller;


import liveeasystreet.dicegame.controller.geomusteel.domain.Player;
import liveeasystreet.dicegame.controller.geomusteel.domain.PlayerDTO;
import liveeasystreet.dicegame.controller.geomusteel.repository.JwRepository;
import liveeasystreet.dicegame.controller.geomusteel.service.JwService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Slf4j
@Controller
@RequiredArgsConstructor
public class JwDiceController {

    public final JwRepository repository;
    public final JwService service;

    @GetMapping("/jw-dice")
    public String jwHome(@ModelAttribute("playerDTO") PlayerDTO playerDTO) {
        return "geomusteel/jw-dice";
    }

    @PostMapping("/jw-dice")
    public String jwDice(@Validated @ModelAttribute("playerDTO") PlayerDTO playerDTO,
                         BindingResult bindingResult) {

        // 실패로직
        if (bindingResult.hasErrors()) {
            return "geomusteel/jw-dice";
        }

        // 성공로직
        String playerName1 = playerDTO.getPlayerName1();
        String playerName2 = playerDTO.getPlayerName2();
        repository.setMembersName(playerName1,playerName2);




        return "redirect:/jw-home";
    }

    @GetMapping("/jw-home")
    public String jwDiceHome(@ModelAttribute("player") Player player,
                             Model model) {

        Player player1 = repository.getMember("player1");
        Player player2 = repository.getMember("player2");

        int winnerCheck = service.winnerCheck(player1,player2);

        model.addAttribute("player1", player1);
        model.addAttribute("player2", player2);
        model.addAttribute("winnerCheck", winnerCheck);

        return "geomusteel/jw-home";
    }

    @GetMapping("/jw-roll")
    public String jwDiceRoll(){

        Random random = new Random();
        Player player1 = repository.getMember("player1");
        Player player2 = repository.getMember("player2");

        int player1Number = random.nextInt(6) + 1;
        int player2Number = random.nextInt(6) + 1;

        player1.setDiceNumber(player1Number);
        player2.setDiceNumber(player2Number);

        player1.getDiceHistory().add(player1Number);
        player2.getDiceHistory().add(player2Number);

        int tempPlayer1Score = player1.getDiceHistory().stream()
                .reduce(Integer::sum)
                .get();

        int tempPlayer2Score = player2.getDiceHistory().stream()
                .reduce(Integer::sum)
                .get();

        player1.setTotalScore(tempPlayer1Score);
        player2.setTotalScore(tempPlayer2Score);

        return "redirect:/jw-home";
    }
    
    
}
