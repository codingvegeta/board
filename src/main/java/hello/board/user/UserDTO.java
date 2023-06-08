package hello.board.user;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {
    @Min(value = 3,message = "최소 3글자 이상 작성해주세요")
    @Max(5)
    @NotNull
    private String userName;

    @Min(2)
    @NotNull
    private String nickName;

}
