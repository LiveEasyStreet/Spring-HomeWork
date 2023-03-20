package liveeasystreet.dicegame.controller.geomusteel.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;


@Getter
@Setter
public class PlayerDTO {

    @Size(max = 10,message = "10자 이하로 입력해주세요.")
    @NotBlank(message = "이름을 정상적으로 입력해주세요.")
    private String playerName1;

    @Size(max = 10,message = "10자 이하로 입력해주세요.")
    @NotBlank(message = "이름을 정상적으로 입력해주세요.")
    private String playerName2;

}
