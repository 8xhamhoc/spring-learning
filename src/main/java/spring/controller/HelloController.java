package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.model.Welcome;

@RestController
public class HelloController {

    @GetMapping("/")
    public Welcome hello() {
        Welcome welcome = new Welcome();
        welcome.setMsg("Hello");
        return welcome;
    }

}
