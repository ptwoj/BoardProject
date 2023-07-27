package com.board.domain.dto;

import java.sql.Timestamp;

public class SearchDto {
    private String username;
    private String name;
    private int id;
    private String title;
    private String content;
    private String category;
    private Timestamp createAt ;

//    toString 은 값을 제대로 받아오는지 확인하기 위해서 만듬
//    @Override
//    public String toString() {
//        return "SearchDto{" +
//                "username='" + username + '\'' +
//                ", name='" + name + '\'' +
//                ", id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                ", category='" + category + '\'' +
//                ", createAt=" + createAt +
//                '}';
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public SearchDto(String username, String name, int id, String title, String content, String category, Timestamp createAt) {
        this.username = username;
        this.name = name;
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.createAt = createAt;
    }
}
