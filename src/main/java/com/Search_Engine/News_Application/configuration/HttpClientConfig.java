package com.Search_Engine.News_Application.configuration;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HttpClientConfig {

    @Bean
    public CloseableHttpClient httpClient(){
        return HttpClients.createDefault();
    }
}
