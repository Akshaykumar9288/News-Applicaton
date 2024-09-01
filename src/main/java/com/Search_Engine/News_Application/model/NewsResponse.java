package com.Search_Engine.News_Application.model;

import java.util.List;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.Gson;
import java.util.ArrayList;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
public class NewsResponse {



    List<NewsHeadline> articles;
    public List<NewsResponse> parseNews(String jsonResponse) {
        List<NewsResponse> newsList = new ArrayList<>();
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonArray articles = jsonObject.getAsJsonArray("articles");
        Gson gson = new Gson();
        for (JsonElement articleElement : articles) {
            JsonObject articleObject = articleElement.getAsJsonObject();
            NewsResponse news = gson.fromJson(articleObject, NewsResponse.class);
            newsList.add(news);
        }
        return newsList;
    }

    public List<NewsHeadline> getArticles(){
        return articles;
    }
    public void setArticles(List<NewsHeadline> articles){
        this.articles = articles;
    }

}