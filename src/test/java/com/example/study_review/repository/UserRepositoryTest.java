package com.example.study_review.repository;

import com.example.study_review.StudyReviewApplication;
import com.example.study_review.StudyReviewApplicationTests;
import com.example.study_review.model.entity.Item;
import com.example.study_review.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

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

    @Test
    @Transactional
    public void read() {
        // findById : select * from user where id = ?
        Optional<User> user = userRepository.findByAccountAndEmail("TestUser02", "TestUser01@gmail.com");
        user.ifPresent(selectUser -> {
            selectUser.getOrderDetailLsit().stream().forEach(detail -> {
                Item item = detail.getItem();
                System.out.println(item);
            });
        });
    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }

    @Test
    @Transactional // 롤
    public void delete() {
        Optional<User> user = userRepository.findById(1L);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        Assertions.assertFalse(deleteUser.isPresent());
    }

}
