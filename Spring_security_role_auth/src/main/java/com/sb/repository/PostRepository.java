package com.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.entity.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
