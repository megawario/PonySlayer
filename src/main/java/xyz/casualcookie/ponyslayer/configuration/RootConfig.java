package xyz.casualcookie.ponyslayer.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Configure Context of spring application
 * 
 * @author mpinto
 *
 */
@Configuration
@PropertySource("/WEB-INF/config/app.properties")
@Import({DBConfig.class,ServicesConfig.class,RepositoryConfig.class,SecurityConfig.class})
@ComponentScan(basePackages = { "xyz.casualcookie.ponyslayer" }, 
excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class RootConfig {}
