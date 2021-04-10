package com.example.study_review.model.entity;

import com.example.study_review.model.enumclass.UserStatus;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // == table, Entity 임을 명시
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"orderGroupList"})
@Builder
@Accessors(chain = true)
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL 옵
    private Long id;

    private String account;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // 1 : N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;

    // LAZY = 지연로딩, EAGER = 즉시로딩
    // LAZY = SELECT * FROM item where id = ?
    // EAGER = 1:1에 추천
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?

}
