package com.wf.site.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;

import com.wf.site.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    
}
