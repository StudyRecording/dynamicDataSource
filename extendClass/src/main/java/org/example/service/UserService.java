package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.pojo.UserPojo;

import java.util.List;

/**
 * Author: hpc
 * Date: 2022/10/17 10:55
 * FileName: UserService
 * Description:
 */
public interface UserService extends IService<UserPojo> {

    List<UserPojo> listUser();

    Boolean addUser(UserPojo userPojo);
}
