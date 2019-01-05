package demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CDPlayerConfig {
}
/*
Configuration
Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime, for example:

@Configuration
public class AppConfig {
    @Bean
    public MyBean myBean() {
        // instantiate, configure and return bean ...
    }
}

ComponentScan
Configures component scanning directives for use with @Configuration classes.
Either basePackageClasses() or basePackages() may be specified to define specific packages to scan.
If specific packages are not defined, scanning will occur from the package of the class that declares this annotation.

*/
