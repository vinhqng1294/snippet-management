package com.vqn.snippetmanagement.controller;

import com.vqn.snippetmanagement.model.dto.SnippetDTO;
import com.vqn.snippetmanagement.model.utils.ResponseDTO;
import com.vqn.snippetmanagement.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/snippets")
public class SnippetController {
    @Autowired
    private SnippetService snippetService;

    @GetMapping("/")
    public Iterable<?> getSnippets() {
        return snippetService.getSnippets();
    }

    @GetMapping("/{id}")
    public <T> T getSnippet(@PathVariable("id") Integer id) {
        SnippetDTO result = snippetService.getSnippetById(id);
        if (result == null) {
            return new ResponseDTO().notFound();
        }
        return (T) result;
    }

    @PostMapping("/add")
    public <T> T addSnippet(@RequestBody @Valid SnippetDTO snippetDto) {
        SnippetDTO result = snippetService.addSnippet(snippetDto);
        if (result == null) {
            return new ResponseDTO().invalid();
        }
        return (T) result;
    }

    @PutMapping("/{id}")
    public <T> T updateSnippet(@PathVariable("id") Integer id, @RequestBody @Valid SnippetDTO snippetDTO) {
        try {
            SnippetDTO result = snippetService.updateSnippet(id, snippetDTO);
            if (result == null) {
                return new ResponseDTO().invalid();
            }
            return (T) result;

        } catch (NoSuchElementException e) {
            return new ResponseDTO().notFound();
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteSnippet(@PathVariable("id") Integer id) {
        return snippetService.deleteSnippetById(id);
    }

}
