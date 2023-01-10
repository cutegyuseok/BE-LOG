package com.example.blog.xenium.member.service;

import com.example.blog.xenium.member.dto.OrderList;
import com.example.blog.xenium.member.repository.MemberRepository;
import com.example.blog.xenium.page.controller.XeniumPageController;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import java.util.List;

@SpringBootTest
class MemberServiceTest {
    /*@Mock
    MemberRepository memberRepository;

    private MockMvc mockMvc;
    protected MockHttpSession session;
    @InjectMocks
    private MemberService memberService;

    @Test
    void selectOrderList() {
        List<OrderList> list;

        given(memberService.selectOrderList("2606982945"));

    }*/

    /*@BeforeEach
    void setUp(@Autowired XeniumPageController pageController){
        mockMvc= MockMvcBuilders.standaloneSetup(pageController).build();
        session = new MockHttpSession();
        session.setAttribute("id","2606982945");
    }*/
}
//2606982945