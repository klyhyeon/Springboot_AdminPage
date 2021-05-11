package com.study.admin.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GetController.class)
class GetControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getMethodTest() throws Exception {
        this.mvc.perform(get("/api/getMethod"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hi ")));
    }

    @Test
    public void getMultiParameterTest() throws Exception {
        this.mvc.perform(get("/api/getMultiParameter")
                .requestAttr("account", "lee")
                .requestAttr("email", "lee@gmail.com")
                .requestAttr("page", 2))
                .andExpect(request().attribute("account", "2"));
    }

}