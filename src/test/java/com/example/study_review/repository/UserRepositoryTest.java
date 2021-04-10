package com.example.study_review.repository;

import com.example.study_review.StudyReviewApplication;
import com.example.study_review.StudyReviewApplicationTests;
import com.example.study_review.model.entity.Item;
import com.example.study_review.model.entity.User;
import com.example.study_review.model.enumclass.UserStatus;
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

        String account = "Test01";
        String password = "Test01";
        UserStatus status = UserStatus.REGISTERED;
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);

        User u = User.builder()
                .account(account)
                .password(password)
                .email(email)
                .build();

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);

    }

    @Test
    @Transactional
    public void read() {

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        if(user != null){

            user.getOrderGroupList().stream().forEach(orderGroup -> {

                System.out.println("-------------주문묶음-------------");
                System.out.println("수령인 : " + orderGroup.getRevName());
                System.out.println("수령지 : " + orderGroup.getRevAddress());
                System.out.println("총금액 : " + orderGroup.getTotalPrice());
                System.out.println("총수량 : " + orderGroup.getTotalQuantity());

                System.out.println("-------------주문상세-------------");
                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("파트너사 : " + orderDetail.getItem().getPartner().getName());
                    System.out.println("카테코리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문상품 : " + orderDetail.getItem().getName());
                    System.out.println("고객센터 : " + orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문상태 : " + orderDetail.getStatus());
                    System.out.println("도착예정 : " + orderDetail.getArrivalDate());
                });
            });

        }

        Assertions.assertNotNull(user);

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
