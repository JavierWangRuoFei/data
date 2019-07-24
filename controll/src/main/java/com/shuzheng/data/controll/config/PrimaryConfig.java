package com.shuzheng.data.controll.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @Author : JavierWang
 * @Date : Created in 12:12 2019-07-20
 * @Description : primary数据源配置
 * @Version : 0.0.1-SNAPSHOT
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.shuzheng.data.persistent"},
        entityManagerFactoryRef = "entityManagerFactoryPrimary",
        transactionManagerRef = "transactionManagerPrimary"
)
@Component
public class PrimaryConfig {
    private static final Logger log = LoggerFactory.getLogger(PrimaryConfig.class);
    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource primaryDataSource;
    @Autowired
    private JpaProperties jpaProperties;
    @Primary
    @Bean("entityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
        return  entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }
    @Primary
    @Bean("entityManagerFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder){
        log.info("----------entityManagerFactoryPrimary-------------");
        DataSourceConfig.logDS(primaryDataSource);
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(primaryDataSource);
//        factoryBean.setPackagesToScan("com.shuzheng.data.domain");
//        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        factoryBean.setJpaPropertyMap(getVendorProperties());
//        return factoryBean;
        return builder
                .dataSource(primaryDataSource)
                .properties(getVendorProperties())
                .packages("com.shuzheng.data.domain")
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }
    private Map<String, String> getVendorProperties() {
        return jpaProperties.getProperties();
    }
    @Primary
    @Bean("transactionManagerPrimary")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }
}
