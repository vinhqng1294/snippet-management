package com.vqn.snippetmanagement.model.entity;

import javax.persistence.*;
import java.util.Objects;

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

    @Column(name = "type", length = 255)
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snippet snippet = (Snippet) o;
        return id == snippet.id &&
                Objects.equals(name, snippet.name) &&
                Objects.equals(descriptionTitle, snippet.descriptionTitle) &&
                Objects.equals(descriptionContent, snippet.descriptionContent) &&
                Objects.equals(content, snippet.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descriptionTitle, descriptionContent, content);
    }
}
