package ph.groundgurus.hello.docker.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloRest {
    @GetMapping
    public String hello() {
        return "Hello Docker World!";
    }
}
