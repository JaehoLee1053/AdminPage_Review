package com.example.study_review.repository;

import com.example.study_review.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalUsedRepository  extends JpaRepository<User, Long> {
}
