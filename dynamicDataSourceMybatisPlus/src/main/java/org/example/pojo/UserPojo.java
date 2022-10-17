package org.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Author: hpc
 * Date: 2022/10/17 09:47
 * FileName: UserPojo
 * Description:
 */
@Data
@TableName("user")
public class UserPojo implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    private static final long serialVersionUID = -2425871593381972029L;
}
