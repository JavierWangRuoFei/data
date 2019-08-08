package com.shuzheng.data.controll.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author : JavierWang
 * @Date : Created in 14:55 2019-07-26
 * @Description : HiveJdbcConfiguration测试
 * @Version : 1.0.0
 */
@SpringBootTest
@RunWith(value = SpringRunner.class)
public class HiveJdbcConfigurationTest {
    @Autowired
    private HiveJdbcConfiguration hiveJdbcConfiguration;
    @Test
    public void testHiveJdbcConfiguration(){
        JdbcTemplate jdbcTemplate = hiveJdbcConfiguration.hiveJdbcTemplate();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        DataSourceConfig.logDS(jdbcTemplate.getDataSource());
    }
}
