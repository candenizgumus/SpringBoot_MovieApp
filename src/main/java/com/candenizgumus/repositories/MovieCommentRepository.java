package com.candenizgumus.repositories;

import com.candenizgumus.entities.Movie;
import com.candenizgumus.entities.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCommentRepository extends JpaRepository<MovieComment,Long>
{
}
