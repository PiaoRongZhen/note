package demo;

import org.springframework.stereotype.Component;

@Component
public class MyPerformance implements Performance {

    public void perform() {
        System.out.println("performing......");
    }
}
