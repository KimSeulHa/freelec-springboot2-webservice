package com.seulha.admin.web.domain.posts;
import com.seulha.admin.domain.posts.Posts;
import com.seulha.admin.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After //(1)
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void submit_board() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() //(2)
                .title(title)
                .content(content)
                .author("kimsha21@naver.com")
                .build());

        List<Posts> postsList = postsRepository.findAll(); //(3)

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
//다른 설정없이 스프링부트 테스트를 사용할 경우, h2데이터베이스를 자동으로 실행시켜 줍니다.


