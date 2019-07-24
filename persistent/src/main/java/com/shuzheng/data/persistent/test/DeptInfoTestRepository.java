package com.shuzheng.data.persistent.test;

import com.shuzheng.data.domain.test.DeptInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeptInfoTestRepository extends JpaRepository<DeptInfo, Integer> {
//    Iterable<DeptInfo> findAll();
}
