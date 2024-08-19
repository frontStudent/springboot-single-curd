package org.syb001.singlecurd.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserAddDto {


    @NotBlank(message = "用户名不能为空")
    private String username;
}
