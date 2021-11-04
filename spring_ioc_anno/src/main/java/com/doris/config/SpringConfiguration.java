package com.doris.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;

//标志该类是Spring的核心配置类
@Configuration
@ComponentScan("com.doris")
//<context:property-placeholder location="classpath*:jdbc.properties"/>
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {


}
