package ru.io6.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.io6.demo.component.SecretConfig;

@RestController
public class WelcomeController {
    @Autowired
    private SecretConfig secretConfig;
    @GetMapping(path = "/welcome")
    public final String welcome() {
        return "Welcome to Spring /n" + secretConfig.getBaseUrl() + "/n" + secretConfig.getTokenTnkRead();
    }
}
