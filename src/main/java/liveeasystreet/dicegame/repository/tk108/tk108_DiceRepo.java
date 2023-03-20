package liveeasystreet.dicegame.repository.tk108;

import liveeasystreet.dicegame.domain.TK_Dice;
import liveeasystreet.dicegame.domain.TK_DiceHistory;

public interface tk108_DiceRepo {
    public TK_Dice save(int sequence, TK_Dice dice);
    public TK_DiceHistory findAll();



    public void clearHistory();
}

