package com.shuzheng.data.controll.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * @Author : JavierWang
 * @Date : Created in 14:42 2019-07-26
 * @Description : HiveDataSourceConfig测试
 * @Version : 1.0.0
 */
@SpringBootTest
@RunWith(value = SpringRunner.class)
public class HiveDataSourceConfigTest {
    @Autowired
    private HiveDataSourceConfig hiveDataSourceConfig;
    @Test
    public void testHiveDataSourceConfig(){
        DataSource dataSource = hiveDataSourceConfig.hiveDataSource();
        DataSourceConfig.logDS(dataSource);
    }
}
