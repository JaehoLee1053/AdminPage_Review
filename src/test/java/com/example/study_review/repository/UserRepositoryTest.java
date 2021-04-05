package com.example.study_review.repository;

import com.example.study_review.StudyReviewApplication;
import com.example.study_review.StudyReviewApplicationTests;
import com.example.study_review.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyReviewApplicationTests {

    // 대표적인 디자인 패턴 DI (Dependency Injection)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("TestUser02");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-2222");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser02");

        User newUser = userRepository.save(user);
        // save() : 받은 타입을 return, DB에 저장된 객체 return id도 붙어나옴
        System.out.println("newUser : " + newUser);
    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }

}
