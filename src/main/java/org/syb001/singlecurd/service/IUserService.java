package org.syb001.singlecurd.service;

import org.syb001.singlecurd.pojo.User;

import java.util.List;

public interface IUserService {
    User getUserById(Integer id);

    List<User> getAllUser();
    void addUser(String username);
    void updateUser(Integer id, String username);
    void deleteUser(Integer id);
}
