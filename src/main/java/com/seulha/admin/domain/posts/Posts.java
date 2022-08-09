package com.seulha.admin.domain.posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //(1) 룸복의 어노테이션
@NoArgsConstructor //(2) 룸복의 어노테이션
@Entity //(3)JPA의 어노테이션
public class Posts {

    @Id //(3)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //(4)
    private Long id;

    @Column(length = 500, nullable = false) //(5)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) //(5)
    private String content;
    private String author;

    @Builder //(6)
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}

/*
    ** 주요 어노테이션을 클래스에 가깝게 두어 정렬한다.
    ** Posts 클래스는 실제 DB 테이블과 매칭될 클래스이며, Entity 클래스라고 한다.
       JPA는 이 Entity 클래스의 수정을 통해 작업하고 실제 쿼리를 날리지는 않는다.

    (1) Getter
        : 클래스 내 모든 필드에 getter 메소드를 자동 생성

    (2) NoArgsConstructor
        : 기본 생성자 자동 추가 = public Posts() {}

    (3) Entity
        : 테이블과 링크될 클래스임을 나타내는 것. 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭함
         ex) PostManager.java -> post_mangager table

    (4) GeneratedValue
        : pk 생성 규칙을 나타냄.
        ** strategy = GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 됨 **

    (5) Column
        : 테이블의 칼럼을 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 됨
         사용하는 이유: 기본 값 외에 추가호 변경이 필요한 경우
         ex) 기본값 VARCHAR(255)를 -> VARCHAR(500)로 늘리고 싶을 때

    (6) Builder
        : 빌더 패더 클래스 생성. 상단에 생성자 선언시, 포함된 필드만 빌더에 포함함
*/
