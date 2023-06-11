package hello.board.user;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @Size(min = 3, max = 5)
    @NotNull
    private String userName;

    @Size(min = 3, max = 5)
    @NotNull
    private String nickName;


}
