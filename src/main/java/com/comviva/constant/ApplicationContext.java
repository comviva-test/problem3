package com.comviva.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({@PropertySource(value = "classpath:application.properties")})
public class ApplicationContext {
	
	@Autowired
    private Environment env;
 
    public String getProperty(String propName) {
        return env.getProperty(propName);
    }

}
