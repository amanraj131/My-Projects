package com.springmvc.configuration;

import java.sql.DriverManager;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import javax.xml.ws.BindingType;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.springmvc")

public class HelloWorldConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}
	
	@Bean(name="dataSource")
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DataSource getDataSource(@Value("${jdbc.url}") String url,@Value("${jdbc.driverClassName}") String driverClassName,@Value("${username}") String username,@Value("${password}") String password){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		
		return ds;
	}
	@Bean(name="jndiDataSource")
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DataSource getJNDIDataSource(@Value("${jdbc.jndiName}") String jndiName) throws NamingException{
		JndiTemplate jndiTemplate = new JndiTemplate();
		DataSource dataSource
        = (DataSource) jndiTemplate.lookup(jndiName);
		
		return dataSource;
	}
	@Bean(name="propertyPlaceholderConfigurer")
	    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
	    {
	        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
	        ppc.setLocation(new ClassPathResource("database.properties"));
	        ppc.setIgnoreUnresolvablePlaceholders(true);
	        return ppc;
	    }

		@Bean(name="jdbctemplate")
		public JdbcTemplate getJdbcTemplate(@Autowired @Qualifier("jndiDataSource") DataSource ds){
			JdbcTemplate jdbcTemplate=new JdbcTemplate(ds);
			return jdbcTemplate;
			
		}
	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}*/

	

}