package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.ann.DS;
import org.example.config.MultipleDataSource;
import org.example.enumpack.DataSourceEnum;
import org.springframework.stereotype.Component;

/**
 * Author: hpc
 * Date: 2022/10/17 13:59
 * FileName: DataSouceAop
 * Description: 数据源切换的切面
 */
@Component
@Aspect
public class DataSouceAop {

    /**
     * 方法的前置通知
     * @param point
     * @param ds
     */
    @Before("@annotation(ds)")
    public void before(JoinPoint point, DS ds) {
        DataSourceEnum value = ds.value();
        MultipleDataSource.name.set(value);
    }
}
