package ru.io6.demo.config;

import io.netty.channel.ChannelOption;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import ru.io6.demo.configSecret.SecretConfig;

import static ru.io6.demo.configSecret.SecretConfig.TOKEN_TNK_READ;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient createWebCustomerClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000);

        return WebClient.builder()
                .baseUrl(SecretConfig.BASE_URL)
                .defaultHeader("Authorization", "Bearer " + TOKEN_TNK_READ)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
