package org.example.config;

import org.example.enumpack.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * Author: hpc
 * Date: 2022/10/17 11:13
 * FileName: MultipleDataSource
 * Description: 声明动态数据源
 */
@Component
@Primary
public class MultipleDataSource extends AbstractRoutingDataSource {

    public static ThreadLocal<DataSourceEnum> name = new ThreadLocal<>();

    @Autowired
    DataSource test;

    @Autowired
    DataSource test2;

    @Override
    protected Object determineCurrentLookupKey() {
        return name.get();
    }

    @Override
    public void afterPropertiesSet() {
        Map<Object, Object> targetDataSources=new HashMap<>();
        targetDataSources.put(DataSourceEnum.READ, test);
        targetDataSources.put(DataSourceEnum.WRITE, test2);
        super.setTargetDataSources(targetDataSources);
        super.setDefaultTargetDataSource(test);

        super.afterPropertiesSet();
    }
}
