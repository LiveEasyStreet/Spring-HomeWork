package liveeasystreet.dicegame.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class TK_DiceList {
    private List<TK_Dice> history;

    public void add(TK_Dice dice){
        history.add(dice);
    }
}
