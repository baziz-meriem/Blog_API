package com.example.runnersApp.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;

    @NotBlank
    private String title;
    @NotBlank
    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Type contentType;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private String url;


    public Content(Integer id, Integer userId, String title, String desc, Status status, Type contentType, LocalDateTime dateCreated, LocalDateTime dateUpdated, String url) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = desc;
        this.status = status;
        this.contentType = contentType;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.url = url;
    }

    public Content() {

    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getContentType() {
        return contentType;
    }

    public void setContentType(Type contentType) {
        this.contentType = contentType;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public String toString() {
        return "Content{ "+
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", desc='" + description + '\'' +
                ", status=" + status +
                ", contentType=" + contentType +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                ", url='" + url + '\'' +
                "}";
    }
}
