package org.syb001.singlecurd.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserUpdateDto extends UserAddDto{
    @NotNull(message = "id不能为空")
    Integer id;
}
