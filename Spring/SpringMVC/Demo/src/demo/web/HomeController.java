package demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value="/", method=org.springframework.web.bind.annotation.RequestMethod.GET)
    public String home() {
        return "home";
    }
}
