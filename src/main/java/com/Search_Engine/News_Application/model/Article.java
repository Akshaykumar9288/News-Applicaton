package com.Search_Engine.News_Application.model;

public class Article {

    private String title;
    private String description;
    private String urlToImage;
    // Add other fields as needed

    // Constructors, getters, and setters

    public Article() {
    }

    public Article(String title, String description,String urlToImage) {
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;

    }

    // Getters and setters


    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                '}';
    }
}
