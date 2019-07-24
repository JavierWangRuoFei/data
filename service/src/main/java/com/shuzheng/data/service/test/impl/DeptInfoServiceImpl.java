package com.shuzheng.data.service.test.impl;

import com.shuzheng.data.domain.test.DeptInfo;
import com.shuzheng.data.persistent.test.DeptInfoTestRepository;
import com.shuzheng.data.service.test.DeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : JavierWang
 * @Date : Created in 15:19 2019-07-20
 * @Description : deptinfo-service实现类
 * @Version : 0.0.1-SNAPSHOT
 */
@Service(value = "deptInfoServiceTest")
public class DeptInfoServiceImpl implements DeptInfoService {
    @Autowired
    private DeptInfoTestRepository deptInfoTestRepository;
    DeptInfoServiceImpl(){
        System.out.println("1111111111111111111111111");
    }
//    @Autowired
//    DeptInfoServiceImpl(DeptInfoRepository deptInfoRepository){
//        this.deptInfoRepository = deptInfoRepository;
//    }

    @Override
    public List<DeptInfo> findAll() {
        List<DeptInfo> deptInfos = new ArrayList<>();
        Sort.Order order = Sort.Order.asc("id");
        Sort sort = Sort.by(order);
        Iterable<DeptInfo> deptInfoIterable = deptInfoTestRepository.findAll();
        deptInfoIterable.forEach(record -> {
            deptInfos.add(record);
        });
        return deptInfos;
    }
}
