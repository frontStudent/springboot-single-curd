package org.syb001.singlecurd.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.syb001.singlecurd.common.enums.ErrorEnum;
import org.syb001.singlecurd.dto.request.UserQueryDto;
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
    public List<User> getUserByCondition(UserQueryDto userQueryDto) {
        return userMapper.getUserByCondition(userQueryDto);
    }

    @Override
    public void addUser(String username) {
        // 检查用户名是否已存在
        UserQueryDto userQueryDto = new UserQueryDto();
        userQueryDto.setUsername(username);
        List<User> result = userMapper.getUserByCondition(userQueryDto);
        if(!result.isEmpty()) {
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
