package liveeasystreet.dicegame.controller.mulmer663;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class DiceForm {

    private int number;
    private Map<Integer, Integer> history;
}
