package org.syb001.singlecurd.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 给前端的统一响应结果
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private String code;
    private String message;

    private T data;

    public static <T> Result<T> success(String message, T data){
        return new Result<T>("SUCCESS", message, data);
    }

    public static <T> Result<T> fail(String message, T data){
        return new Result<T>("FAIL", message, data);
    }
}
