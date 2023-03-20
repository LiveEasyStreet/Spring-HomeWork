package liveeasystreet.dicegame.controller.geomusteel.service;

import liveeasystreet.dicegame.controller.geomusteel.domain.Player;
import liveeasystreet.dicegame.controller.geomusteel.repository.JwRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwServiceImp implements JwService {

    private final JwRepository repository;

    public void setMembersName(String playerName1, String playerName2) {
        Player player1 = new Player(playerName1);
        Player player2 = new Player(playerName2);
        repository.getMembers().put("player1", player1);
        repository.getMembers().put("player2", player2);
    }

    public Player getMember(String member) {
        return repository.findMember(member);
    }

    public int winnerCheck(Player player1, Player player2) {

        int totalScore1 = player1.getTotalScore();
        int totalScore2 = player2.getTotalScore();

        if (totalScore1 >= 50 || totalScore2 >= 50) {
            if (totalScore1 > totalScore2) {
                return 1;
            }
            if (totalScore2 > totalScore1) {
                return 2;
            }
            return 3;
        }

        return 0;
    }

}
