package org.example.mapper.w;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.UserPojo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: hpc
 * Date: 2022/10/17 10:55
 * FileName: UserMapper
 * Description:
 */
@Repository
public interface WUserMapper {


    @Select("select * from user")
    List<UserPojo> select();

    @Insert("insert into user(`name`, `age`, `email`) values (#{name}, #{age}, #{email})")
    int insert(UserPojo userPojo);
}
