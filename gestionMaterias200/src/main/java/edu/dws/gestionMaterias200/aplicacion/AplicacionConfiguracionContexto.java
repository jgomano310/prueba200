package edu.dws.gestionMaterias200.aplicacion;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import edu.dws.gestionMaterias200.aplicacion.DAL.Alumno;


@Configuration
@ComponentScan
@PropertySource("classpath:propiedades.properties")
@EnableJpaRepositories("edu.dws.gestionMaterias200.aplicacion.DAL")
public class AplicacionConfiguracionContexto {

	@Autowired
	private Environment enviroment;
	@Bean
	public DataSource dataSource () {
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(enviroment.getProperty("db.driver"));
		datasource.setUrl(enviroment.getProperty("db.url"));
		datasource.setUsername(enviroment.getProperty("db.username"));
		datasource.setPassword(enviroment.getProperty("db.password"));
		
		return datasource;
		
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoy() {
		
		LocalContainerEntityManagerFactoryBean local = new LocalContainerEntityManagerFactoryBean();
		local.setDataSource(dataSource());
		local.setPackagesToScan(Alumno.class.getPackage().getName());
		
		 HibernateJpaVendorAdapter jpa = new HibernateJpaVendorAdapter();
		 jpa.setDatabase(Database.POSTGRESQL);
		 jpa.setDatabasePlatform(enviroment.getProperty("hibernate-dialect"));
		 jpa.setGenerateDdl(enviroment.getProperty("hibernate.generateDdl", Boolean.class));
		 jpa.setShowSql(enviroment.getProperty("hibernate.show_sql", Boolean.class));
	     local.setJpaVendorAdapter(jpa);
	     
	     Properties jpaProp = new Properties();
	     jpaProp.put("hibernate.hbm2ddl.auto", enviroment.getProperty("hibernate.hbm2ddl.auto"));
	     jpaProp.put("hibernate.show_sql", enviroment.getProperty("hibernate.show_sql"));
	     jpaProp.put("hibernate.format_sql", enviroment.getProperty("hibernate.format_sql"));
	     local.setJpaProperties(jpaProp);
		return local;
		
	}
	
	 @Bean
	    public JpaTransactionManager transaction() {
	        JpaTransactionManager jpa = new JpaTransactionManager();
	        jpa.setEntityManagerFactory(entityManagerFactoy().getObject());
	        return jpa;
	    }

}

