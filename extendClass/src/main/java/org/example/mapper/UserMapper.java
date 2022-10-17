package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.UserPojo;
import org.springframework.stereotype.Repository;

/**
 * Author: hpc
 * Date: 2022/10/17 10:55
 * FileName: UserMapper
 * Description:
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserPojo> {
}
