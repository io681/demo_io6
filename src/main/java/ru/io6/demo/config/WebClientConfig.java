package ru.io6.demo.config;

import io.netty.channel.ChannelOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import ru.io6.demo.component.SecretConfig;

@Configuration
public class WebClientConfig {
    @Autowired
    private SecretConfig secretConfig;

    @Autowired
    private Environment environment;

    @Bean
    public WebClient createWebCustomerClient() {
        String baseUrl;
        String bearer;
        String currentProfile = environment.getActiveProfiles()[0];

        if (currentProfile.equals("prod")) {
            baseUrl = secretConfig.getBaseUrl();
            bearer = secretConfig.getTokenTnkRead();
        } else {
            baseUrl = System.getenv("BASE_TEST_URL");
            bearer = System.getenv("TOKEN_TNK_READ");
        }

        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000);

        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer " + bearer)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

}
