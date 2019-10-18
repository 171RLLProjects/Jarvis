package com.mphasis.jarvis.conf;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages="com.mphasis.jarvis.*")
@EnableAspectJAutoProxy
@EnableWebMvc
public class AppConfig {
	
	
	@Bean
	public DriverManagerDataSource getDataSource() {
		
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@172.21.41.17:1521:xe");
		ds.setUsername("flight");
		ds.setPassword("flight");
		return ds;
		
}
@Bean
public LocalSessionFactoryBean getSessionFactory() {
	LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
	sessionFactory.setDataSource(getDataSource());
	Properties pro=new Properties();
	pro.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
	pro.put("hibernate.hbm2ddl.auto","update");
	pro.put("hibernate.show_sql","true");
	pro.put("hibernate.format_sql","true");
	sessionFactory.setHibernateProperties(pro);
	sessionFactory.setPackagesToScan("com.mphasis.jarvis.entities");
	return sessionFactory;
	
}

@Bean
public WebMvcConfigurer corsConfigurer()
{
return new WebMvcConfigurerAdapter() {
	

	public void addCorsMappings(CorsRegistry registry)
	{
		
		registry.addMapping("/**").allowedOrigins("*")
		.allowedMethods("HEAD","GET" ,"POST" ,"PUT" , "DELETE" , "OPTION")
		.allowedHeaders("Origin","X-Requested-Width","Content-Type","Access-Control-Allow-Origin");
		
	}

};
}

}
