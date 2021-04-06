package com.example.study_review.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    // 1 : N

    // LAZY = 지연로딩, EAGER = 즉시로딩
    // LAZY = SELECT * FROM item where id = ?
    // EAGER = 1:1에 추천
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderDetail> orderDetailLsit;

}
