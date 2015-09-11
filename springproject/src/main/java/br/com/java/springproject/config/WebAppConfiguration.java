package br.com.java.springproject.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.java.codehouse.dao.PersonDAO;
import br.com.java.codehouse.dao.ProfessorDAO;
import br.com.java.codehouse.dao.TurmaDAO;
import br.com.java.springproject.controller.AlunoController;
import br.com.java.springproject.controller.PersonController;
import br.com.java.springproject.controller.ProfessorController;
import br.com.java.springproject.controller.TurmaController;

@EnableWebMvc
@ComponentScan(basePackageClasses={PersonController.class,PersonDAO.class,TurmaController.class,TurmaDAO.class,ProfessorController.class,ProfessorDAO.class,AlunoController.class})
public class WebAppConfiguration {


	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
		bundle.setBasename("WEB-INF/messages");
		bundle.setDefaultEncoding("UTF-8");
		bundle.setCacheSeconds(1);
		return bundle;
	}
	
	
	@Bean
	public FormattingConversionService mvcConversionService(){
		DefaultFormattingConversionService coversionServive = new DefaultFormattingConversionService(true);
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("HH:mm"));
		registrar.registerFormatters(coversionServive);
		return coversionServive;
	}
	
	
	
	
	
	
}
