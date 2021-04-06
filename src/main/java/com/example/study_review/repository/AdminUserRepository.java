package com.example.study_review.repository;

import com.example.study_review.model.entity.AdminUser;
import com.mysql.cj.jdbc.JdbcPreparedStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
}
