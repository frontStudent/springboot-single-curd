package org.syb001.singlecurd.service;

import org.syb001.singlecurd.dto.request.UserQueryDto;
import org.syb001.singlecurd.pojo.User;

import java.util.List;

public interface IUserService {

    List<User> getUserByCondition(UserQueryDto userQueryDto);

    void addUser(String username);
    void updateUser(Integer id, String username);
    void deleteUser(Integer id);
}
