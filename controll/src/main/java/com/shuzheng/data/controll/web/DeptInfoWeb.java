package com.shuzheng.data.controll.web;

import com.shuzheng.data.domain.DeptInfo;
import com.shuzheng.data.service.DeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Author : JavierWang
 * @Date : Created in 16:12 2019-07-20
 * @Description : deptinfo操作
 * @Version : 0.0.1-SNAPSHOT
 */
@RestController
public class DeptInfoWeb {
    @Autowired
    private DeptInfoService deptInfoService;
    @Autowired
    private com.shuzheng.data.service.test.DeptInfoService deptInfoServiceTest;
//    private static DeptInfoWeb deptInfoWeb;
//    @PostConstruct
//    public void init(){
//        deptInfoWeb = this;
//        deptInfoWeb.deptInfoService = this.deptInfoService;
//
//    }
//    public DeptInfoWeb(DeptInfoService deptInfoService){
//        this.deptInfoService = deptInfoService;
//    }
    @PostMapping(value = "/data/all")
    public List<DeptInfo> findAll(){
        return deptInfoService.findAll();
    }
    @PostMapping(value = "/data/test/all")
    public List<com.shuzheng.data.domain.test.DeptInfo> findAllTest() {
        return deptInfoServiceTest.findAll();
    }
}
