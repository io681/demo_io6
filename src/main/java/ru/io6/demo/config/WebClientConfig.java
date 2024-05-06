package ru.io6.demo.config;

import io.netty.channel.ChannelOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import ru.io6.demo.component.SecretConfig;

@Configuration
public class WebClientConfig {
    @Autowired
    private SecretConfig secretConfig;
    @Bean
    public WebClient createWebCustomerClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000);

        return WebClient.builder()
//                .baseUrl("https://sandbox-invest-public-api.tinkoff.ru/rest")
                .baseUrl(secretConfig.getBaseUrl())
                .defaultHeader("Authorization", "Bearer " + secretConfig.getTokenTnkRead())
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
