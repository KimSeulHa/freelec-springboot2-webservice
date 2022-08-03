package com.seulha.admin.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
/*
     Repository의 이해
     : 보통 Mybatis에서 DAO라고 불리는 DB 접근자를 JPA에서는 Repository라고 부르며 인터페이스로 생성한다.
     1) JpaRepository<Posts,Long>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
     2) Entity 클래스(Posts)와 기본 Entity Repository는 함께 위치해야 한다.
        -> 프로젝트가 커져서 도메인별로 프로젝트를 분리해야 한다면,
            이때도 역시 Entity클래스와 기본 Repository는 함께 움직여야 하므로 도메인 패키지에서 함께 관리한다.
*/
public interface PostsRepository extends JpaRepository<Posts,Long> {


}
