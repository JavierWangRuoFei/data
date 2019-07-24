package com.shuzheng.data.controll;

import com.shuzheng.data.controll.config.DataSourceConfig;
import com.shuzheng.data.controll.config.PrimaryConfig;
import com.shuzheng.data.controll.config.SecondConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration()
@ComponentScan(basePackages={"com.shuzheng.data"})
@EntityScan({"com.shuzheng.data.domain"})
public class DataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataApplication.class, args);

	}

}
