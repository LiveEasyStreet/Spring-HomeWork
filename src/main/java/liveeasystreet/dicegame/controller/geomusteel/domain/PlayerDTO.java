package liveeasystreet.dicegame.controller.geomusteel.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PlayerDTO {

    @NotBlank(message = "이름을 정상적으로 입력해주세요.")
    private String playerName1;

    @NotBlank(message = "이름을 정상적으로 입력해주세요.")
    private String playerName2;

}
