package com.shuzheng.data.controll.config;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @Author : JavierWang
 * @Date : Created in 11:54 2019-07-20
 * @Description : 数据库配置类
 * @Version : 0.0.1-SNAPSHOT
 */
@Configuration
@PropertySource("classpath:/conf/mysql.properties")
public class DataSourceConfig {
    private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "secondDataSource")
    @Qualifier("secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 显示数据库连接池信息
     *
     * @param dataSource
     */
    public static void logDS(DataSource dataSource) {
        HikariDataSource hds = (HikariDataSource) dataSource;
        String info = "\n\n\tHikariCP连接池配置\n\t连接池名称：" +
                hds.getPoolName() +
                "\n\t最小空闲连接数：" +
                hds.getMinimumIdle() +
                "\n\t数据库地址：" +
                hds.getJdbcUrl() +
                "\n\t最大连接数：" +
                hds.getMaximumPoolSize() +
                "\n\t连接超时时间：" +
                hds.getConnectionTimeout() +
                "ms\n\t空闲连接超时时间：" +
                hds.getIdleTimeout() +
                "ms\n\t连接最长生命周期：" +
                hds.getMaxLifetime() +
                "ms\n";
        log.info(info);
    }
}
