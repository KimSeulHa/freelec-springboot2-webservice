package com.seulha.admin.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)//(1)
@WebMvcTest(controllers = HelloController.class)//(2)
public class HelloControllerTest {

    @Autowired//(3)
    private MockMvc mvc;//(4)

    @Test
    public void hello() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }

    @Test
    public void helloDto() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount))).andExpect(status().isOk()).andExpect(jsonPath("$.name",is(name))).andExpect(jsonPath("$.amount",is(amount)));
        //(8)(9)
    }
}


/*
    (1) RunWith
        :테스트를 진행할 때, JUnit에 내장된 실행자 외 다른 실행자를 실행시킴.
        **SpringRunner.class = SpringRunner 라는 실행자를 사용한다는 의미

    (2) WebMvcTest
        스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션임.
        - @Controller, @ControllerAdvice 사용 가능
        - @Service, @Component, @Repository 사용 불가능

    (3) Autowired
        :스프링이 관리하는 빈(Bean)을 받음

    (4) MockMvc
        :웹 API 사용. 이 클래스를 통해 HTTP GET, POST 등에 대한 API를 테스트 할 수 있음
        + 웹 어플리케이션을 애플리케이션 서버에 배포하지 않고 테스트용 mvc환경을 만들어 요청 및 전송, 응답기능을 제공해주는 유틸리티 클래

    (5) mvc.perform
        :MockMVC를 통해 /Hello 주소로 HTTP GET을 요청함
        체이닝이 지원되어 여러 **검증 기능**을 이어서 선언 가능함

    (6) andExpect(status().isOk())
    **mvc.perform의 검증 기능**
        :HTTP Header의 Status를 검증 (200,404,500의 상태를 검증)

    (7) andExpect(content().string(스트링 들어가는 곳))
    **mvc.perform의 검증 기능**
        :응답하는 내용을 검증

    (8) param
        :API 테스트할 때 사용될 ''요청 파라미터''를 설정
        **값은 Sting만 허용되기 때문에 숫자 데이터를 등록할 때는 문자열로 변경해야만 한다.
        ex) param("amount",String.valueOf(amount))

    (9) jsonPath *검증 메소드*
        : JSON 응답값을 필드별로 검증할 수 있는 메소드이다.
        $를 기준으로 필드명을 명시한다.

 */
