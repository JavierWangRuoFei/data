package com.shuzheng.data.service.impl;

import com.shuzheng.data.domain.DeptInfo;
import com.shuzheng.data.persistent.DeptInfoRepository;
import com.shuzheng.data.service.DeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author : JavierWang
 * @Date : Created in 15:19 2019-07-20
 * @Description : deptinfo-service实现类
 * @Version : 0.0.1-SNAPSHOT
 */
@Service
public class DeptInfoServiceImpl implements DeptInfoService {
    @Autowired
    @Qualifier(value = "entityManagerFactoryPrimary")
    private EntityManagerFactory entityManagerFactoryPrimary;
    @Autowired
    private DeptInfoRepository deptInfoRepository;
    DeptInfoServiceImpl(){}
//    @Autowired
//    DeptInfoServiceImpl(DeptInfoRepository deptInfoRepository){
//        this.deptInfoRepository = deptInfoRepository;
//    }

    @Override
    public List<DeptInfo> findAll() {
        List<DeptInfo> deptInfos = new ArrayList<>();
        Sort.Order order = Sort.Order.asc("id");
        Sort sort = Sort.by(order);
        deptInfos = deptInfoRepository.findAll(sort);
        return deptInfos;
    }
}
