package org.example.controller;

import org.example.pojo.UserPojo;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: hpc
 * Date: 2022/10/17 10:58
 * FileName: UserController
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<UserPojo> list() {
        return userService.listUser();
    }

    @PostMapping("/add")
    public Boolean add(@RequestBody UserPojo userPojo) {
        return userService.addUser(userPojo);
    }
}
