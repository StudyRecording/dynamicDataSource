package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.ann.DS;
import org.example.config.MultipleDataSource;
import org.example.enumpack.DataSourceEnum;
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

//    @DS(DataSourceEnum.READ)
    @Override
    public List<UserPojo> listUser() {
//        MultipleDataSource.name.set(DataSourceEnum.READ);
        return this.list();
    }

//    @DS(DataSourceEnum.WRITE)
    @Override
    public Boolean addUser(UserPojo userPojo) {
//        MultipleDataSource.name.set(DataSourceEnum.WRITE);
        return this.save(userPojo);
    }
}
