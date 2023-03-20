package liveeasystreet.dicegame.repository.tk108;

import liveeasystreet.dicegame.domain.TK_Dice;
import liveeasystreet.dicegame.domain.TK_DiceHistory;
import liveeasystreet.dicegame.domain.TK_DiceList;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class tk108_DiceRepository implements tk108_DiceRepo{
    private static final Map<Integer, TK_Dice> store = new HashMap<>();

    @Override
    public TK_Dice save(int sequence, TK_Dice dice){
        store.put(sequence,dice);

        return dice;
    }
    @Override
    public TK_DiceHistory findAll(){
        TK_DiceHistory diceHistory = new TK_DiceHistory();
        diceHistory.setHistory(store);

        return diceHistory;
    }


    @Override
    public void clearHistory() {
        store.clear();
    }
}
