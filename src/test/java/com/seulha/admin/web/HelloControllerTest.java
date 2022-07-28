package com.seulha.admin.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}
/*
    (1) 테스트를 진행할 때, JUnit에 내장된 실행자 외 다른 실행자를 실행시킴.
        SpringRunner 라는 실행자를 사용한다는 의미

    (2) 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션임.
        - @Controller, @ControllerAdvice 사용 가능
        - @Service, @Component, @Repository 사용 불가능

    (3) 스프링이 관리하는 빈(Bean)을 받음

    (4) 웹 API 사용. 이 클래스를 통해 HTTP GET, POST 등에 대한 API를 테스트 할 수 있음

    (5) MockMVC를 통해 /Hello 주소로 HTTP GET을 요청함
        체이닝이 지원되어 여러 **검증 기능**을 이어서 선언 가능함

    (6) **mvc.perform의 검증 기능**
        HTTP Header의 Status를 검증 (200,404,500의 상태를 검증)

    (7) **mvc.perform의 검증 기능**
        응답하는 내용을 검증








 */
