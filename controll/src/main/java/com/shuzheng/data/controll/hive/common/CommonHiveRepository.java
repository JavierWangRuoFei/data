package com.shuzheng.data.controll.hive.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author : JavierWang
 * @Date : Created in 15:00 2019-07-26
 * @Description : hive操作工具类
 * @Version : 1.0.0
 */
@Component
public class CommonHiveRepository {
    private static final Logger log = LoggerFactory.getLogger(CommonHiveRepository.class);

    @Autowired
    @Qualifier(value = "hiveJdbcTemplate")
    private JdbcTemplate hiveJdbcTemplate;

    public List<Map<String, Object>> queryForList(String hiveSQL){
        log.info("开始执行sql:{};return:List<Map<String, Object>>",hiveSQL);
        try {
            return hiveJdbcTemplate.queryForList(hiveSQL);
        } catch (Exception e){
            log.error("～～～执行sql:{};失败",hiveSQL);
            e.printStackTrace();
            return null;
        }
    }

    public <T> List<T> queryForList(String hiveSQL, Class<T> elementType){
        log.info("开始执行sql:{};return:List<{}>",hiveSQL,elementType.getName());
        try {
            return hiveJdbcTemplate.queryForList(hiveSQL,elementType);
        } catch (Exception e){
            log.error("～～～执行sql:{};失败",hiveSQL);
            e.printStackTrace();
            return null;
        }
    }

}
