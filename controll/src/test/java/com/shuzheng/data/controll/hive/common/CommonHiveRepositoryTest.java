package com.shuzheng.data.controll.hive.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author : JavierWang
 * @Date : Created in 15:20 2019-07-26
 * @Description : CommonHiveRepository测试
 * @Version : 1.0.0
 */
@SpringBootTest
@RunWith(value = SpringRunner.class)
public class CommonHiveRepositoryTest {
    @Autowired
    private CommonHiveRepository commonHiveRepository;
    @Test
    public void testQueryForList(){
        String sql = "show databases";
        String sql1 = "show tables in sf_hj";
        List<String> databases = commonHiveRepository.queryForList(sql1, String.class);
        databases.forEach(record -> {
            System.out.println(record);
        });
    }
}
