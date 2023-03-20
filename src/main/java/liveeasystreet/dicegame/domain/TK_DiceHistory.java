package liveeasystreet.dicegame.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class TK_DiceHistory {
    private Map<Integer, TK_Dice> history;
}
