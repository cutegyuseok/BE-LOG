package com.example.blog.xenium.page.controller;

import com.example.blog.xenium.member.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
class XeniumPageControllerTest {
    private MockMvc mockMvc;
    protected MockHttpSession session;

    @Mock
    private MemberService memberService;
    @InjectMocks
    private XeniumPageController pageController;

    @Test
    void orderList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/xenium/orderList")
                .session(session)).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @BeforeEach
    void setUp(@Autowired XeniumPageController pageController){
        mockMvc= MockMvcBuilders.standaloneSetup(pageController).build();
        session = new MockHttpSession();
        session.setAttribute("id","2606982945");
    }
}