package org.wanwanframework.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8080/
 * @author coco
 *
 */
@RestController
@EnableAutoConfiguration
public class SpringBoot {

    @RequestMapping("/")
    String home() {
        return "home";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBoot.class, args);
    }
}