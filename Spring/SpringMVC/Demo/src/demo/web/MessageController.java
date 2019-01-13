package demo.web;

import demo.data.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping(value="/message", method=org.springframework.web.bind.annotation.RequestMethod.GET)
    public String message(@RequestParam(value="count", defaultValue="20") int count, Model model) {
        model.addAttribute("messageList", messageRepository.findMessage(count));
        return "message";
    }
}
