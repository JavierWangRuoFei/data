package com.shuzheng.data.service;

import com.shuzheng.data.domain.DeptInfo;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author : JavierWang
 * @Date : Created in 15:31 2019-07-20
 * @Description : DeptInfoService测试
 * @Version : 0.0.1-SNAPSHOT
 */

@SpringBootTest(classes = Base.class)
@RunWith(value = SpringRunner.class)
public class DeptInfoServiceTest {

    @Autowired
    private DeptInfoService deptInfoServiceImpl;

    @Test
    public void findAllTest(){
        List<DeptInfo> deptInfos = deptInfoServiceImpl.findAll();
        deptInfos.forEach(record -> {
            System.out.println(record.toString());
        });
    }
}
