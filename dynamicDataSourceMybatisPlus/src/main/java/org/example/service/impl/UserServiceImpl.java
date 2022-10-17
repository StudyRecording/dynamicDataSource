package org.example.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mapper.UserMapper;
import org.example.pojo.UserPojo;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: hpc
 * Date: 2022/10/17 10:57
 * FileName: UserServiceImpl
 * Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPojo> implements UserService {

    @DS("test")
    @Override
    public List<UserPojo> listUser() {
        return this.list();
    }

    @DS("test2")
    @Override
    public Boolean addUser(UserPojo userPojo) {
        return this.save(userPojo);
    }
}
