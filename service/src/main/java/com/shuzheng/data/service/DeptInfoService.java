package com.shuzheng.data.service;

import com.shuzheng.data.domain.DeptInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeptInfoService {
    List<DeptInfo> findAll();
}
