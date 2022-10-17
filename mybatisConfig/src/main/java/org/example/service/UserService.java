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
public interface UserService {

    List<UserPojo> listR();
    List<UserPojo> listW();

    boolean saveR(UserPojo userPojo);
    boolean saveW(UserPojo userPojo);

    void saveAll(UserPojo userPojo);

}
