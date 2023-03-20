package liveeasystreet.dicegame.controller.geomusteel.service;

import liveeasystreet.dicegame.controller.geomusteel.domain.Player;

public interface JwService {
    void setMembersName(String playerName1, String playerName2);

    Player getMember(String member);

    int winnerCheck(Player player1, Player player2);
}
