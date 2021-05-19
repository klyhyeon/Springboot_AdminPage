package com.study.admin.repository;

import com.study.admin.AdminApplicationTests;
import com.study.admin.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends AdminApplicationTests {

    @Autowired // DI 의존성 주입 -> 싱글톤 패턴
    private UserRepository userRepository;

    @Test
    public void create() {
        String account = "Test02";
        String password = "Test02";
        String status = "REGISTERED";
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
                .status(status)
                .email(email)
                .build();

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read() {
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {

            System.out.println("----------주문묶음---------------");
            System.out.println(orderGroup.getRevAddress());
            System.out.println(orderGroup.getTotalPrice());
            System.out.println(orderGroup.getTotalQuantity());
            System.out.println(orderGroup.getRevName());
            System.out.println("------------주문상세------------");
            orderGroup.getOrderDetailList().stream().forEach(orderDetail -> {
                System.out.println("주문 상품: " + orderDetail.getItem().getName());
                System.out.println("상품 카테고리: " + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("고객센터 번호: " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태 : " + orderDetail.getStatus());
                System.out.println("도착예정일자: " + orderDetail.getArrivalDate());
            });
        });

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
    @Transactional
    public void delete() {
        Optional<User> user = userRepository.findById(3L);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });
        Optional<User> deleteUser = userRepository.findById(3L);

        Assertions.assertFalse(deleteUser.isPresent());
    }

}
