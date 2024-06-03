package com.fsje.dairy.common.config;

import javax.management.ObjectName;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;
/*
@Configuration
@EnableTransactionManagement(order = 1, proxyTargetClass = true)
@ImportResource(locations = {"classpath:/config/database/transaction-config.xml"})
*/
public class DataBaseConfig {
	//@Value("classpath*:/com/fsje/dairy/**/*.sqlx")
	/*
	private Resource[] mapperLocations;

	@Value("classpath*:/config/database/mybatis-config.xml")
	private Resource configLocations;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build(); 
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setConfigLocation(configLocations);
		sqlSessionFactory.setMapperLocations(mapperLocations);
		
		return sqlSessionFactory.getObject();
	}
	
	@Bean
	public DataSourceMonitoring dataSourceMonitoring(@Qualifier("dataSource") HikariDataSource dataSource) throws Exception {
		ObjectName objectName = new ObjectName("com.fsje:type=DataSource,name=hikari-pool,context=/");
		DataSourceMonitoring dataSourceMonitoring = new DataSourceMonitoring(dataSource,objectName);
		
		return dataSourceMonitoring;
	}
	
	@Bean
	@Primary
	public SqlManager sqlManager(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		SqlManager sqlManager = new SqlManager();
		sqlManager.setSqlSessionFactory(sqlSessionFactory);
		return sqlManager
	}
	*/
}
