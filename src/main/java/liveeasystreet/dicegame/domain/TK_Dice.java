package liveeasystreet.dicegame.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TK_Dice {
    private int last_number;
    private int number;
    private String id;
}
