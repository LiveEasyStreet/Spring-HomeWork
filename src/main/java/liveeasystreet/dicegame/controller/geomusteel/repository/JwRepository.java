package liveeasystreet.dicegame.controller.geomusteel.repository;

import liveeasystreet.dicegame.controller.geomusteel.domain.Player;

import java.util.Map;

public interface JwRepository {

    Player findMember(String playerName);

    Map<String, Player> getMembers();

    void saveMemberName(String playerName, Player player);
}
