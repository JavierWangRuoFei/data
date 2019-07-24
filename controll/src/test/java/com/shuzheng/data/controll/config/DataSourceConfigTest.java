package com.shuzheng.data.controll.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * @Author : JavierWang
 * @Date : Created in 12:05 2019-07-20
 * @Description : DataSourceConfig测试
 * @Version : 0.0.1-SNAPSHOT
 */
@SpringBootTest
@RunWith(value = SpringRunner.class)
public class DataSourceConfigTest {
    @Autowired
    private DataSourceConfig dataSourceConfig;
    @Test
    public void testDataSource(){
        DataSource dataSource = dataSourceConfig.primaryDataSource();
        DataSource dataSource1 = dataSourceConfig.secondDataSource();
        DataSourceConfig.logDS(dataSource);
        DataSourceConfig.logDS(dataSource1);
    }
}
