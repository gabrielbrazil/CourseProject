package br.com.java.springproject.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.java.codehouse.dao.AlunoDAO;
import br.com.java.codehouse.dao.PersonDAO;
import br.com.java.codehouse.dao.ProfessorDAO;
import br.com.java.codehouse.dao.TurmaDAO;
import br.com.java.springproject.controller.AlunoController;
import br.com.java.springproject.controller.PersonController;
import br.com.java.springproject.controller.ProfessorController;
import br.com.java.springproject.controller.TurmaController;
import br.com.java.springproject.converters.ArrayStringToListProfessor;

@EnableWebMvc
@ComponentScan(basePackageClasses={PersonController.class,PersonDAO.class,TurmaController.class,TurmaDAO.class,ProfessorController.class,
		ProfessorDAO.class,AlunoController.class,AlunoDAO.class})
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
		FormattingConversionService conversionService = new FormattingConversionService();
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("HH:mm"));
		registrar.registerFormatters(conversionService);
		addConverters(conversionService);
		return conversionService;
	}
	
	
	private void addConverters(FormatterRegistry registry){
		registry.addConverter(new ArrayStringToListProfessor());
		DefaultConversionService.addDefaultConverters(registry);
	    DefaultFormattingConversionService.addDefaultFormatters(registry);
	}
	
	
	
	
}
