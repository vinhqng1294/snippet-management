package com.vqn.snippetmanagement.model.mapper;

import com.vqn.snippetmanagement.model.dto.SnippetDTO;
import com.vqn.snippetmanagement.model.entity.Snippet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SnippetMapper {
    SnippetMapper INSTANCE = Mappers.getMapper(SnippetMapper.class);

    Iterable<SnippetDTO> toSnippetDtos(Iterable<Snippet> snippets);
    Snippet toSnippet(SnippetDTO snippetDTO);
    SnippetDTO toSnippetDto(Snippet snippet);
}
