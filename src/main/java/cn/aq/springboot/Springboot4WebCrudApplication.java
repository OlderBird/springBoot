package cn.aq.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
@ComponentScan(basePackages = {"cn.aq.springboot"})
public class Springboot4WebCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot4WebCrudApplication.class, args);
	}


	@Bean
	public ViewResolver myViewResolver(){
		return new MyViewResolver();
	}

	public static class MyViewResolver implements ViewResolver{

		@Override
		public View resolveViewName(String s, Locale locale) throws Exception {
			return null;
		}
	}
}
