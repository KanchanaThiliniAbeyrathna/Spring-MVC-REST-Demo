package application;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import db.StudentServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan({ "db", "model" ,"controller"})
public class AppConfig extends WebMvcConfigurerAdapter{

	@Autowired
	private ServletContext context;
	
	@Bean
	public StudentServiceImpl getStudentervice(){
		return new StudentServiceImpl();
	}
	
}
