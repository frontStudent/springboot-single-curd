package org.syb001.singlecurd.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.syb001.singlecurd.dto.request.UserQueryDto;
import org.syb001.singlecurd.pojo.User;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> getUserByCondition(UserQueryDto userQueryDto);

    @Insert("insert into test_user(username) values(#{username})")
    Integer addUser(String username);

    @Update("update test_user set username = #{username} where id = #{id}")
    Integer updateUser(Integer id, String username);

    @Delete("delete from test_user where id=#{id}")
    Integer deleteUser(Integer id);
}
