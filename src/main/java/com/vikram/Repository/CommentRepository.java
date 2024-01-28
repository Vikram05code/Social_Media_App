package com.vikram.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikram.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
