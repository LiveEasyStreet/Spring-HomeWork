package liveeasystreet.dicegame.controller.geomusteel.repository;


import liveeasystreet.dicegame.controller.geomusteel.domain.Player;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class JwRepositoryImp implements JwRepository {

    private static final Map<String, Player> member = new HashMap<>();

    public Player findMember(String playerName) {
        return member.get(playerName);
    }

    public Map<String, Player> getMembers() {
        return member;
    }

    @Override
    public void saveMemberName(String playerName, Player player) {
        member.put(playerName, player);
    }
}
