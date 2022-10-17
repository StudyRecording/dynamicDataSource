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

    @GetMapping("/listR")
    public List<UserPojo> listR() {
        return userService.listR();
    }

    @GetMapping("/listW")
    public List<UserPojo> listW() {
        return userService.listW();
    }

    @PostMapping("/saveR")
    public Boolean saveR(@RequestBody UserPojo userPojo) {
        return userService.saveR(userPojo);
    }

    @PostMapping("/saveW")
    public Boolean saveW(@RequestBody UserPojo userPojo) {
        return userService.saveW(userPojo);
    }

    @PostMapping("/saveAll")
    public String saveAll(@RequestBody UserPojo userPojo) {
        userService.saveAll(userPojo);
        return "success";
    }

}
