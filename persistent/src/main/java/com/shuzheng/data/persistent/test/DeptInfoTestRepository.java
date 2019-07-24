package com.shuzheng.data.persistent.test;

import com.shuzheng.data.domain.test.DeptInfoTest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeptInfoTestRepository extends JpaRepository<DeptInfoTest, Integer> {
//    Iterable<DeptInfo> findAll();
}
