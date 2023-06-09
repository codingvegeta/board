package hello.board.user;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDTO {
    @Min(value = 3,message = "최소 3글자 이상 작성해주세요")
    @Size(min = 5)
    @NotNull
    private String userName;

    @Size(min = 3)
    @NotNull
    private String nickName;

}
