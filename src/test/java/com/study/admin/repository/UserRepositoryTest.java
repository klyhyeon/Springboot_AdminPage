package com.study.admin.repository;

import com.study.admin.AdminApplicationTests;
import com.study.admin.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

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
        //System.out.println("id: " + user.getId());
    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }
}
