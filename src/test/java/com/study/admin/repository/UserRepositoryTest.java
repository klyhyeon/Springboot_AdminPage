package com.study.admin.repository;

import com.study.admin.AdminApplicationTests;
import com.study.admin.model.entity.Item;
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
        // String sql = insert into user (%s, %s, %d) value (account, email, page);
        User user = new User(); //  User는 매번 만들어 쓰는 객체값이기 때문에 직접 생성해서 사용
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-3333-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin3");

        User newUser = userRepository.save(user);
        System.out.println("newUser: " + newUser);
    }

    @Test
    @Transactional
    public void read() {
        Optional<User> user = userRepository.findById(4L);

        /** ifPresent()
         * If a value is present, invoke the specified consumer with the value, otherwise do nothing.
         * Params: consumer – block to be executed if a value is present
         * Throws: NullPointerException – if value is present and consumer is null
         * */

        user.ifPresent(selectUser->{
            selectUser.getOrderDetails().stream().forEach(detail->{
                Item item = detail.getItem();
                System.out.println(detail.getItem());
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
