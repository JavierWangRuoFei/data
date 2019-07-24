package com.shuzheng.data.controll.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;

/**
 * @Author : JavierWang
 * @Date : Created in 16:42 2019-07-23
 * @Description : PrimaryConfig测试
 * @Version : 1.0.0
 */
@SpringBootTest
@RunWith(value = SpringRunner.class)
public class PrimaryConfigTest {
    @Autowired
    private PrimaryConfig primaryConfig;
    @Autowired
    private EntityManagerFactory entityManagerFactoryPrimary;
    @Test
    public void testPrimaryConfig(){
        System.out.println(entityManagerFactoryPrimary.toString());
    }
}
