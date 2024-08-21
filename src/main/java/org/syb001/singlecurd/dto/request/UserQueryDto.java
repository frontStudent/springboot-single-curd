package org.syb001.singlecurd.dto.request;

import lombok.Data;


@Data
public class UserQueryDto {
    Integer id;
    String username;
    private String startTime;
    private String endTime;
}
