package com.shuzheng.data.controll.web;

import com.shuzheng.data.controll.config.DataSourceConfig;
import com.shuzheng.data.controll.config.PrimaryConfig;
import com.shuzheng.data.controll.config.SecondConfig;
import com.shuzheng.data.domain.DeptInfo;
import com.shuzheng.data.service.DeptInfoService;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Author : JavierWang
 * @Date : Created in 15:31 2019-07-20
 * @Description : DeptInfoService测试
 * @Version : 0.0.1-SNAPSHOT
 */

@RunWith(SpringRunner.class)
@SpringBootTest
//@Configuration
@Import({DataSourceConfig.class, PrimaryConfig.class, SecondConfig.class})
@EnableJpaRepositories({"com.shuzheng.data"})
@EntityScan({"com.shuzheng.data"})
public class DeptInfoWebTest {

    @Autowired
    private DeptInfoWeb deptInfoWeb;
//    private static DeptInfoWebTest deptInfoWebTest;
//    @PostConstruct
//    public void init(){
//        deptInfoWebTest = this;
//        deptInfoWebTest.deptInfoWeb = this.deptInfoWeb;
//
//    }

    @Test
    public void findAllTest(){
        System.out.println(deptInfoWeb==null? "1111111111111111111111":"222222222222222222222222");
//        List<DeptInfo> deptInfos = deptInfoWeb.findAll();
//        deptInfos.forEach(record -> {
//            System.out.println(record.toString());
//        });
    }

    @Before
    public void setUp() throws Exception {

    }
}
