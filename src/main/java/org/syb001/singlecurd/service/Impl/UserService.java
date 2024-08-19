package org.syb001.singlecurd.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.syb001.singlecurd.common.enums.ErrorEnum;
import org.syb001.singlecurd.mapper.UserMapper;
import org.syb001.singlecurd.pojo.User;
import org.syb001.singlecurd.service.IUserService;
import org.syb001.singlecurd.common.exception.BizException;

import java.util.List;

@Service("UserService")
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

    @Override
    public void addUser(String username) {
        User result = userMapper.getUserByName(username);
        if(result != null) {
            throw new BizException(ErrorEnum.USER_DUPLICATE);
        }
        userMapper.addUser(username);
    }

    @Override
    public void updateUser(Integer id, String username) {
        Integer rowsAffected = userMapper.updateUser(id, username);
        if (rowsAffected == 0) {
            throw new BizException(ErrorEnum.USER_NOT_FOUND);
        }
    }

    @Override
    public void deleteUser(Integer id) {
        Integer rowsAffected = userMapper.deleteUser(id);
        if (rowsAffected == 0) {
            throw new BizException(ErrorEnum.USER_NOT_FOUND);
        }
    }
}
