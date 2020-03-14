package com.vqn.snippetmanagement.service;

import com.vqn.snippetmanagement.model.dto.SnippetDTO;
import com.vqn.snippetmanagement.model.entity.Snippet;
import com.vqn.snippetmanagement.model.mapper.SnippetMapper;
import com.vqn.snippetmanagement.repository.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SnippetService {
    @Autowired
    private SnippetRepository snippetRepository;

    public Iterable<SnippetDTO> getSnippets() {
        return SnippetMapper.INSTANCE.toSnippetDtos((Iterable<Snippet>) snippetRepository.findAll());
    }

    public SnippetDTO getSnippetById(int id) {
        try {
            return SnippetMapper.INSTANCE.toSnippetDto(snippetRepository.findById(id).get());
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public SnippetDTO addSnippet(SnippetDTO snippetDTO) {
        try {
            return SnippetMapper.INSTANCE.toSnippetDto(snippetRepository.save(SnippetMapper.INSTANCE.toSnippet(snippetDTO))) ;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public boolean deleteSnippetById(Integer id) {
        try {
            snippetRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public SnippetDTO updateSnippet(Integer id, SnippetDTO snippetDTO) {
        try {
            Snippet foundSnippet = snippetRepository.findById(id).get();
            try {
                if (snippetDTO.getName() != null && !snippetDTO.getName().isEmpty()) foundSnippet.setName(snippetDTO.getName());
                if (snippetDTO.getDescriptionTitle() != null && !snippetDTO.getDescriptionTitle().isEmpty())
                    foundSnippet.setDescriptionTitle(snippetDTO.getDescriptionTitle());
                if (snippetDTO.getDescriptionContent() != null && !snippetDTO.getDescriptionContent().isEmpty())
                    foundSnippet.setDescriptionContent(snippetDTO.getDescriptionContent());
                if (snippetDTO.getContent() != null && !snippetDTO.getContent().isEmpty())
                    foundSnippet.setContent(snippetDTO.getContent());
                if (snippetDTO.getType() != null && !snippetDTO.getType().isEmpty())
                    foundSnippet.setType(snippetDTO.getType());
                return SnippetMapper.INSTANCE.toSnippetDto(snippetRepository.save(foundSnippet));
            } catch (IllegalArgumentException e) {
                return null;
            }
        } catch (NoSuchElementException e) {
            throw e;
        }
    }
}
