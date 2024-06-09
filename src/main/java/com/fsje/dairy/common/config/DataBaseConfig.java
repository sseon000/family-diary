package com.fsje.dairy.common.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @file   : DataBaseConfig
 * @author : KSH
 * @brief  : 데이터베이스 컨피그
 * @see    : N/A
 * @since  : 2024.06.09
 */
@Configuration
/**
 * 어노테이션 기반 트랜잭션관리 사용 설정
 * <tx:annotation-driven>
 */
@EnableTransactionManagement
@PropertySource("application.properties")
public class DataBaseConfig {
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("classpath*:/com/fsje/dairy/**/*.sqlx")
	private Resource[] mapperLocations;
	@Value("classpath:/config/mybatis-config.xml")
	private Resource configLocations;

	/**
	 * DataSource설정
	 * @param driverClassName
	 * @param url
	 * @param username
	 * @param password
	 * @reutrn dataSource  
	 */
	@Bean
	public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(driverClassName);
	    dataSource.setUrl(url);
	    dataSource.setUsername(username);
	    dataSource.setPassword(password);

	    return dataSource;
	}

	/**
	 * TransactionManager설정
	 * @param dataSource  
	 */
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
		
	/**  
	 * SqlSessionFactory 설정  
	 *  
	 * <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">  
	 *  <property name="dataSource" ref="dataSource" />  
	 *  <property name="configLocation" value="classpath:mybatis/configuration.xml" />  
	 * <property name="mapperLocations" value="classpath:mybatis/mappers/** /*.xml" />  
	 * </bean>  
	 *  
	 * @param dataSource  
	 * @param mapperLocations 
	 * @param configLocations 
	 * @return  
	 * @throws IOException  
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setConfigLocation(configLocations);
		sqlSessionFactory.setMapperLocations(mapperLocations);
			
		return sqlSessionFactory.getObject();
	}
		
	/**  
	  * SqlSessionTemplate 설정  
	  *  
	  * <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">  
	  *  <constructor-arg ref="sqlSessionFactory" />  
	  * </bean>  
	  *  
	  * @param sqlSessionFactory  
	  * @return  
	  */
	@Bean 
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
