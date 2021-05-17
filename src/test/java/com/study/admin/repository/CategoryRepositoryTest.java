package com.study.admin.repository;


import com.study.admin.AdminApplicationTests;
import com.study.admin.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends AdminApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create() {
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category categoryTemp = new Category();
        categoryTemp.setType(type);
        categoryTemp.setTitle(title);
        categoryTemp.setCreatedAt(createdAt);
        categoryTemp.setCreatedBy(createdBy);

        Category category = categoryRepository.save(categoryTemp);
        Assertions.assertNotNull(category);
        Assertions.assertEquals(category.getType(), type);
        Assertions.assertEquals(category.getTitle(), title);
    }

    @Test
    public void read() {
        String type = "COMPUTER";
        Optional<Category> category = categoryRepository.findByType(type);
        category.ifPresent(selectCategory->{
            Assertions.assertEquals(type, selectCategory.getType());
            System.out.println(selectCategory.getId());
            System.out.println(selectCategory.getTitle());
            System.out.println(selectCategory.getType());
        });
    }
}
