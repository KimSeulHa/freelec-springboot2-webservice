package com.seulha.admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication
// 스프링 부트의 자동설정, 스프링 bean 읽기와 생성을 모두 자동으로 설정할 수 있음
public class Application {
    //메인 클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        /*SpringApplication.run으로 인해 내장 WAS를 실행할 수 있음(톰캣 설치 필요가 없음)
          -> 내장 WAS를 사용하면 각 서버에 설치된 같은 WAS 환경을 구축해야 할 필요가 없고
            그로 인한 실수를 줄일 수 있음
        */
    }
}
