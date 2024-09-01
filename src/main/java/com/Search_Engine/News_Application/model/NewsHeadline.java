package com.Search_Engine.News_Application.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "NewsHeadline")
public class NewsHeadline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime localDateTime;
    private String description;
    private String urlToImage;





    // Constructors, getters, and setters
    public NewsHeadline() {
    }

    public NewsHeadline(Long id, String title, String content, LocalDateTime localDateTime, String description, String urlToImage) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.localDateTime = localDateTime;
        this.description = description;
        this.urlToImage = urlToImage;
    }

    // Additional methods (if needed)
    public String getImgUrl() {
        return urlToImage;
    }

    public void setImgUrl(String url) {
        this.urlToImage = urlToImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return localDateTime;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.localDateTime = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NewsHeadline{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", localDateTime=" + localDateTime +
                ", description='" + description + '\'' +
                ", ImgUrl='" + urlToImage + '\'' +
                '}';
    }
}
