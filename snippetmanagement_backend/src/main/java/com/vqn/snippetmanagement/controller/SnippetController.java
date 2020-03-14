package com.vqn.snippetmanagement.controller;

import com.vqn.snippetmanagement.model.Snippet;
import com.vqn.snippetmanagement.repository.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/snippets")
public class SnippetController {
    @Autowired
    private SnippetRepository snippetRepository;

    @GetMapping("/")
    public ResponseEntity<List<Snippet>> getSnippets() {
        return ResponseEntity.ok((List<Snippet>) snippetRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Snippet> getSnippet(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(snippetRepository.findById(id).get());
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Snippet> addSnippet(@RequestBody Snippet snippet) {
        try {
            return ResponseEntity.ok(snippetRepository.save(snippet));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Snippet> updateSnippet(@PathVariable("id") Integer id, @RequestBody Snippet snippet) {
        try {
            Snippet foundSnippet = snippetRepository.findById(id).get();
            try {
                if (snippet.getName() != null && !snippet.getName().isEmpty()) foundSnippet.setName(snippet.getName());
                if (snippet.getDescriptionTitle() != null && !snippet.getDescriptionTitle().isEmpty())
                    foundSnippet.setDescriptionTitle(snippet.getDescriptionTitle());
                if (snippet.getDescriptionContent() != null && !snippet.getDescriptionContent().isEmpty())
                    foundSnippet.setDescriptionContent(snippet.getDescriptionContent());
                if (snippet.getContent() != null && !snippet.getContent().isEmpty())
                    foundSnippet.setContent(snippet.getContent());
                return ResponseEntity.ok(snippetRepository.save(foundSnippet));
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSnippet(@PathVariable("id") Integer id) {
        try {
            snippetRepository.deleteById(id);
            return ResponseEntity.ok(new Object() {
                public boolean success = true;
            });
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Object() {
                public boolean success = false;
                public String message = "Illegal request!";
            });
        }
    }
}
