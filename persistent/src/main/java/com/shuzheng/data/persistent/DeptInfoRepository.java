package com.shuzheng.data.persistent;

import com.shuzheng.data.domain.DeptInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface DeptInfoRepository extends JpaRepository<DeptInfo, Integer> {
//    Iterable<DeptInfo> findAll();
}
