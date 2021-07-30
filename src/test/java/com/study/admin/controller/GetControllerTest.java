package com.study.admin.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import sun.security.util.Debug;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GetController.class)
class GetControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void addition () {
        assertEquals(2, 1+1);
    }

    @Test
    public void getHeaderTest() throws Exception {
        this.mvc.perform(get("/api/header"))
                .andExpect(content().string(containsString("transaction_time")))
                .andExpect(content().string(containsString("result_code")));

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