package com.vqn.snippetmanagement.model.dto;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class SnippetDTO {
    private int id;

    @NotNull
    private String name;

    private String descriptionTitle;

    private String descriptionContent;

    private String content;

    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        SnippetDTO that = (SnippetDTO) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(descriptionTitle, that.descriptionTitle) &&
                Objects.equals(descriptionContent, that.descriptionContent) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descriptionTitle, descriptionContent, content);
    }
}
