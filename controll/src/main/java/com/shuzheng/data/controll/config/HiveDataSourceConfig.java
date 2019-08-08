package com.shuzheng.data.controll.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @Author : JavierWang
 * @Date : Created in 14:28 2019-07-26
 * @Description : hive数据源配置类
 * @Version : 1.0.0
 */
@Configuration
@PropertySource("classpath:/conf/hive.properties")
public class HiveDataSourceConfig {

    private static final Logger log = LoggerFactory.getLogger(HiveDataSourceConfig.class);

    @Bean(name = "hiveDataSource")
    @Qualifier("hiveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hive")
    public DataSource hiveDataSource(){
        return DataSourceBuilder.create().build();
    }
}
