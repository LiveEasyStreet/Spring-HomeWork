package liveeasystreet.dicegame.controller.geomusteel.repository;


import liveeasystreet.dicegame.controller.geomusteel.domain.Player;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class JwRepository {

    Map<String, Player> member = new HashMap<>();

    public void setMembersName (String playerName1,String playerName2) {
        Player player1 = new Player(playerName1);
        Player player2 = new Player(playerName2);
        member.put("player1", player1);
        member.put("player2", player2);
    }

    public Player getMember (String playerName){
        return member.get(playerName);
    }





}
