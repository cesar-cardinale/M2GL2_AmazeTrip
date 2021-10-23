package com.amazetrip.api.dao;

import com.amazetrip.api.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CommentRepo extends CrudRepository<Comment, Integer> {
    Collection<Comment> findCommentsByPlace_Id(int id);
}
