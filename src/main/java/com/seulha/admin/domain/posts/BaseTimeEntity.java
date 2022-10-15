package com.seulha.admin.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter //(1)
@MappedSuperclass //(2)
@EntityListeners(AuditingEntityListener.class) //(3)
public class BaseTimeEntity {

    @CreatedDate //(4)
    private LocalDateTime createdDate;

    @LastModifiedDate //(5)
    private LocalDateTime modifiedDate;
}
/*

  (1) @Getter
    : 룸복의 어노테이션. 클래스 내의 모든 getter 메소드를 생성
    **lombok?
      : Java 라이브러리로 반복되는 getter, setter, toString()등의 메서드 작성 코드를 줄여주는 코드 다이어트 라이브러리입니다.

  (2) @MappedSuperclass
    : JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도 칼럼으로 인식하도록 함

  (3) @EntityListeners(AuditingEntityListener.class)
    : baseTimeEntity 클래스에 Auditing 기능을 포함

  (4) @CreatedDate
    : Entity가 생성되어 저장될 때 시간이 자동 저장됨

  (5) @LastModifiedDate
    : 조회한 Entity의 값을 변경할 때 시간이 자동 저장됨

 */
