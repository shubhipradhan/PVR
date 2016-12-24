package com.cinema.SRSBackendQ.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.cinema")
public class AppContextConfig {

	// BEAN FOR CREATING THE OBJECT OF H2 DATABASE
	@Bean

	// FOR DATASOURCE TO RECOGNISED SQL.DATASOURCE IS IMPORT
	public DataSource getH2DataSource() {

		// FOR CREATING AN OBJECT OF DATASOURCE BASICDATASOURCE IS
		// IMPORT
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/SRS");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

	// CREATING LOCAL SESSION OF SESSION-FACTORY

	@Autowired
	@Bean

	// TO CREATE LOCAL-SESSION FACTORY IMPORT LOCALSESSIONFACTORYBEAN
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(dataSource);
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setPackagesToScan(new String[] { "com.cinema.SRSBackendQ.model" });

		return sessionFactory;

	}

	public Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();

		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
	}

}
