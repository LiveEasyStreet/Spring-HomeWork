package liveeasystreet.dicegame.controller.geomusteel.service;

import liveeasystreet.dicegame.controller.geomusteel.domain.Player;
import liveeasystreet.dicegame.controller.geomusteel.repository.JwRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwService {

    public int winnerCheck(Player player1,Player player2) {

        int totalScore1 = player1.getTotalScore();
        int totalScore2 = player2.getTotalScore();


        if (totalScore1 >= 50 || totalScore2 >= 50) {
            if (totalScore1 > totalScore2) {
                return 1;
            }
            if (totalScore2 > totalScore1) {
                return 2;
            }
        }

        if (totalScore1 >= 50 && totalScore2 >= 50 && totalScore1 == totalScore2) {
            return 3;
        }

        return 0;
    }
}
