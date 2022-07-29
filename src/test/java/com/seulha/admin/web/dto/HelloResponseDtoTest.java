package com.seulha.admin.web.dto;
import  org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void helloDto(){

        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name,amount);

        assertThat(dto.getName()).isEqualTo(name); //(1)
        assertThat(dto.getAmount()).isEqualTo(amount); //(2)

    }
}
/*
    (1) assertThat *테스트 검증 메소드*
        - 검증하고 싶은 대상을 메소드 인자로 받음
        (메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용가능)

    (2) isEqualTo *테스트 검증 메소드*
        - 동등 비교 메소드
        - assertThat 이 받은 인자값과 isEqualTo의 값을 비교해서 같을 때 성공
*/
