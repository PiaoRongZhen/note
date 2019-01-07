package demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
To enable @AspectJ support with Java @Configuration,
add the @EnableAspectJAutoProxy annotation, as the following example shows:
*/

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {
}
