package com.demo.Portalback;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.demo")
public class App 
{
	@Bean(name={"dataSource"})
	public DataSource getdataSource()
	{
	BasicDataSource datasource = new BasicDataSource();
	datasource.setDriverClassName("oracle.jdbc.OracleDriver");
	datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	datasource.setUsername("new");
	datasource.setPassword("admin");
	
	return datasource;
	}
	@Bean
	public SessionFactory sessionFactory(DataSource datasource)
	{ 
	LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(datasource);
	localSessionFactoryBuilder.scanPackages("com.demo");
	localSessionFactoryBuilder.addProperties(getProperties());
	return localSessionFactoryBuilder.buildSessionFactory();
	}
	public Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	@Bean
	public HibernateTransactionManager TransactionalManager(SessionFactory sessionFactory)
	{
	HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
	return hibernateTransactionManager;
	}

}
