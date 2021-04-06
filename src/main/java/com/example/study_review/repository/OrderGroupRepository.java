package com.example.study_review.repository;

import com.example.study_review.model.entity.OrderGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderGroupRepository extends JpaRepository<OrderGroup, Long> {
}
