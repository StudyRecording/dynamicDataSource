package org.example.ann;

import org.example.enumpack.DataSourceEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * Author: hpc
 * Date: 2022/10/17 13:55
 * FileName: DS
 * Description: 数据库使用注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DS {

    /**
     * 使用的数据库
     * @return
     */
    DataSourceEnum value() default DataSourceEnum.READ;
}
