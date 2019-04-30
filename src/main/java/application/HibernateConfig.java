package application;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "notDefaultEntityManagerFactory",
    transactionManagerRef = "notDefaultTransactionManager",
    basePackages =  {"application.repositoryImpl"})
public class HibernateConfig {
	
	
	@Primary
	@Bean
	public DataSourceProperties dataSourceProperties() {
		
		DataSourceProperties prop = new DataSourceProperties();
		prop.setDriverClassName("org.h2.Driver");
		prop.setUrl("jdbc:h2:mem:omsaDB");
		prop.setUsername("sa");
		
	    return prop;
	}
	
	@Bean
	public DataSource dataSource(DataSourceProperties properties) {
		
		
		System.out.println(properties.getDriverClassName() + " " + properties.getUrl());
	    return properties
	            .initializeDataSourceBuilder()
	            .type(HikariDataSource.class)
	            .build();
	}

	
	/* @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.h2.Driver");
	        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
	        dataSource.setUsername("sa");
	        dataSource.setPassword("");
	        return dataSource;
	    } */
	 
	 
	 @Bean(name = "notDefaultTransactionManager")
	    PlatformTransactionManager notDefaultTransactionManager(EntityManagerFactory entityManagerFactory) {
	        JpaTransactionManager txManager = new JpaTransactionManager();
	        txManager.setEntityManagerFactory(entityManagerFactory);
	        return txManager;
	    }
	
	 @Primary
	 @Bean(name="myentitymanagerfacotry")
	    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(dataSource(dataSourceProperties()));
	        em.setPackagesToScan("application.domain");
	        em.setPersistenceUnitName("myOwnPersistenceUnit");

	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        vendorAdapter.setGenerateDdl(true);
	        em.setJpaVendorAdapter(vendorAdapter);
	        return em;
	    } 

	

	
	
	
}
