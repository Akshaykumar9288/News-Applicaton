package com.Search_Engine.News_Application.configuration;


import com.Search_Engine.News_Application.model.NewsResponse;
import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.time.LocalDateTime;
import com.Search_Engine.News_Application.utility.LocalDateTimeAdapter;
import org.springframework.stereotype.Service;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
public class NewsApiService {

    @Value("${news.api.key}")
    private String apiKey;
    private final CloseableHttpClient httpClient;
    @Autowired
    public NewsApiService(CloseableHttpClient httpClient){
        this.httpClient = httpClient;
    }

    public NewsResponse fetchHeadlines(String country) throws Exception {
        String url = "https://newsapi.org/v2/top-headlines?country=" + country +"&apiKey=6c5065f9a2fc4317bd286aa291623756";
        HttpGet request = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String responseBody = reader.lines().collect(Collectors.joining());


            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();

            NewsResponse newsResponse = gson.fromJson(responseBody,NewsResponse.class);

            return newsResponse;
        } catch (Exception e) {
            System.out.println("Error is " + e);
            return null;
        }
    }
}
