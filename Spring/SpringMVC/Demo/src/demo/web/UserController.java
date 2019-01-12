package demo.web;

import demo.User;
import demo.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/register", method=org.springframework.web.bind.annotation.RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value="/register", method=org.springframework.web.bind.annotation.RequestMethod.POST)
    public String processRegistration(User user) {

        userRepository.save(user);
        return "redirect:/user/" + user.getUsername();
    }

    @RequestMapping(value="/{username}", method=org.springframework.web.bind.annotation.RequestMethod.GET)
    public String showUserProfile(@PathVariable("username") String username, Model model) {
        User user = userRepository.findByUsername(username);
        model.addAttribute("user", user);
        return "profile";
    }

}
