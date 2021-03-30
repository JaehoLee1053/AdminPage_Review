package com.example.study_review.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity // == table, Entity 임을 명시
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL 옵
    private Long id;

    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

}
