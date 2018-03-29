package net.itspartner.test.n7.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public HelloItsObject sayHello() {
        return new HelloItsObject("Hello, ITS Partner");
    }
}
