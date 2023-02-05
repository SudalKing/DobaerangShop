package com.example.dobaerangshop.domain.user.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;   //
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; // mockMvc 사용을 위한 추가설정

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("1. [loginAccessTest]")
    @Test
    public void loginAccessTest() throws Exception {
        mockMvc.perform(
                get("/login")
        )
                .andExpect(status().isOk());
    }

}