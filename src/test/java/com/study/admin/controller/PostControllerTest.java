package com.study.admin.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

@WebMvcTest(PostController.class)
class PostControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void postMethodTest() throws Exception {
        this.mvc.perform(post("/api/postMethod")
                .requestAttr("account", "lee")
                .requestAttr("email", "lee@gmail.com")
                .requestAttr("page", 2))
                .andExpect(request().attribute("account", "lee"));
    }
}