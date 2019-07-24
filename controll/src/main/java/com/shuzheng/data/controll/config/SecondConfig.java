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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @Author : JavierWang
 * @Date : Created in 14:59 2019-07-20
 * @Description : second数据库config
 * @Version : 0.0.1-SNAPSHOT
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.shuzheng.data.domain"},
        entityManagerFactoryRef = "entityManagerFactoryPrimary",
        transactionManagerRef = "transactionManagerPrimary"
)
public class SecondConfig {
    private static final Logger log = LoggerFactory.getLogger(PrimaryConfig.class);
    @Autowired
    @Qualifier("secondDataSource")
    private DataSource secondDataSource;
    @Autowired
    private JpaProperties jpaProperties;
    @Primary
    @Bean("entityManagerSecond")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
        return  entityManagerFactorySecond(builder).getObject().createEntityManager();
    }
    @Primary
    @Bean("entityManagerFactorySecond")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecond(EntityManagerFactoryBuilder builder){
        log.info("----------entityManagerFactorySecond-------------");
        DataSourceConfig.logDS(secondDataSource);
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(secondDataSource);
        factoryBean.setPackagesToScan("com.shuzheng.data.domain.test");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaPropertyMap(getVendorProperties());
        return factoryBean;

//        return builder
//                .dataSource(secondDataSource)
//                .properties(getVendorProperties())
//                .packages("com.shuzheng.data.domain.test")
//                .persistenceUnit("primaryPersistenceUnit")
//                .build();
    }
    private Map<String, String> getVendorProperties() {
        return jpaProperties.getProperties();
    }
    @Primary
    @Bean("transactionManagerSecond")
    public PlatformTransactionManager transactionManagerSecond(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactorySecond(builder).getObject());
    }
}
