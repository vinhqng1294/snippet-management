package com.vqn.snippetmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_snippet")
public class Snippet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "description_title", length = 255)
    private String descriptionTitle;

    @Column(name = "description_content", columnDefinition = "TEXT")
    private String descriptionContent;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptionTitle() {
        return descriptionTitle;
    }

    public void setDescriptionTitle(String descriptionTitle) {
        this.descriptionTitle = descriptionTitle;
    }

    public String getDescriptionContent() {
        return descriptionContent;
    }

    public void setDescriptionContent(String descriptionContent) {
        this.descriptionContent = descriptionContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
