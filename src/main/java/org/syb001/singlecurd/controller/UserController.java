package org.syb001.singlecurd.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.syb001.singlecurd.dto.request.UserAddDto;
import org.syb001.singlecurd.dto.request.UserQueryDto;
import org.syb001.singlecurd.dto.request.UserUpdateDto;
import org.syb001.singlecurd.pojo.User;
import org.syb001.singlecurd.dto.response.Result;
import org.syb001.singlecurd.service.Impl.UserService;

import java.util.List;

@RestController // = @Controller + @ResponseBody
@CrossOrigin(origins = "*")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getUserByCondition")
    public Result<List<User>> getUserByCondition(@RequestBody UserQueryDto userQueryDto){
        List<User> users = userService.getUserByCondition(userQueryDto);
        return Result.success("查询成功", users);
    }

    @PostMapping("/addUser")
    public Result<Void> addUser(@Valid @RequestBody UserAddDto userAddDto) {
        String username = userAddDto.getUsername();
        userService.addUser(username);
        return Result.success("添加成功", null);
    }

    @PostMapping("/updateUser")
    public Result<Void> updateUser(@Valid @RequestBody UserUpdateDto userUpdateDto){
        Integer id = userUpdateDto.getId();
        String username = userUpdateDto.getUsername();
        userService.updateUser(id, username);
        return Result.success("修改成功", null);
    }

    @GetMapping("/deleteUser")
    public Result<Void> deleteUser(@NotNull(message = "id不能为空") Integer id) {
        userService.deleteUser(id);
        return Result.success("删除成功", null);
    }
}
