package com.shuzheng.data.controll.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Author : JavierWang
 * @Date : Created in 14:51 2019-07-26
 * @Description : hive数据连接配置
 * @Version : 1.0.0
 */
@Configuration
public class HiveJdbcConfiguration {
    @Autowired
    @Qualifier(value = "hiveDataSource")
    private DataSource dataSource;

    @Bean(name = "hiveJdbcTemplate")
    public JdbcTemplate hiveJdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }
}
