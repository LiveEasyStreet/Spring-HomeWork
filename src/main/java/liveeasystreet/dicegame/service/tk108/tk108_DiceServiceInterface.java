package liveeasystreet.dicegame.service.tk108;

import liveeasystreet.dicegame.domain.TK_Dice;
import liveeasystreet.dicegame.domain.TK_DiceHistory;
import liveeasystreet.dicegame.domain.TK_DiceList;

public interface tk108_DiceServiceInterface {
    public void save(TK_Dice dice);

    public void save_temp(TK_Dice dice);

    public TK_DiceList findTen();

    public TK_DiceHistory findAll();

    public void clearHistory();
}
