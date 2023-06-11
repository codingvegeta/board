package hello.board.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Response<T> {
    private boolean success;
    private Integer code;
    private String message;
    private T data;

    public Response(boolean success, T data) {
        this.success = success;
        this.code = 200;
        this.message = "요청에 성공하였습니다.";
        this.data = data;
    }

    public Response(T data) {
        this.success = true;
        this.code = 200;
        this.message = "요청에 성공하였습니다.";
        this.data = data;
    }

    public static <T> Response<T> of(T data) {
        return new Response<>(data);
    }

    public static <T> Response<T> of(boolean success, T data) {
        return new Response<>(success, data);
    }

    public static <T> Response<T> empty() {
        return new Response<>(true, null);
    }
}
