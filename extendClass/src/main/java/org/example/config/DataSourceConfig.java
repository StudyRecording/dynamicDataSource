package org.example.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.plugin.Interceptor;
import org.example.plugins.DataSourcePlugin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Author: hpc
 * Date: 2022/10/17 11:01
 * FileName: DataSourceConfig
 * Description:
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource test() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource test2() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * mybatis插件配置数据源切换
     * @return
     */
    @Bean
    public Interceptor dataSourcePlugin() {
        return new DataSourcePlugin();
    }

    @Bean
    public DataSourceTransactionManager transactionManager1(MultipleDataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }


    @Bean
    public DataSourceTransactionManager transactionManager2(MultipleDataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
