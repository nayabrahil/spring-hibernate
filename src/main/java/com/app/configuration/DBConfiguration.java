package com.app.configuration;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/com/app/configuration/app.properties")
public class DBConfiguration {

	@Autowired
	Environment env;

	@Bean(destroyMethod = "close")
	DataSource dataSource() {
		BasicDataSource dataSourceConfig = new BasicDataSource();
		dataSourceConfig.setDriverClassName(env.getRequiredProperty("db.driver"));
		dataSourceConfig.setUrl(env.getRequiredProperty("db.url"));
		dataSourceConfig.setUsername(env.getRequiredProperty("db.username"));
		dataSourceConfig.setPassword(env.getRequiredProperty("db.password"));

		return dataSourceConfig;
	}
	/*
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.app.domain.entity");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaProperties(jpaProperties());
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	*/
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.app.domain.entity");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		factory.setHibernateProperties(hibernateProperties());
		return factory;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	Properties hibernateProperties() {
		Properties property = new Properties();
		property.setProperty("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		property.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		property.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		return property;
	}

}
