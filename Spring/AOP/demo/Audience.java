package demo;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
With @AspectJ support enabled, any bean defined in your application context with a class that is an @AspectJ aspect (has the @Aspect annotation) is automatically detected by Spring and used to configure Spring AOP.
*/

/*
Note that the @Aspect annotation is not sufficient for autodetection in the classpath.
For that purpose, you need to add a separate @Component annotation
*/
@Component
@Aspect
public class Audience {

    @Before("execution(* demo.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("execution(* demo.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("execution(* demo.Performance.perform(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }
}
