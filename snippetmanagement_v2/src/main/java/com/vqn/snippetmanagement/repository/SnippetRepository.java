package com.vqn.snippetmanagement.repository;

import com.vqn.snippetmanagement.model.Snippet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnippetRepository extends CrudRepository<Snippet, Integer> {
}
