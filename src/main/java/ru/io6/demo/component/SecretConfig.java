package ru.io6.demo.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "conf")
@Getter
@Setter
public class SecretConfig {
    private String baseUrl;
    private String tokenTnkRead;
}
