package kim.zzang.webservice.domain.posts;

import kim.zzang.webservice.dto.posts.PostsMainResponseDto;
import kim.zzang.webservice.repository.PostsRepository;
import kim.zzang.webservice.service.PostsService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    PostsService postsService;

    @After
    public void cleanup() {
        /** 
        이후 테스트 코드에 영향을 끼치지 않기 위해 
        테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
        **/
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntity_등록 () {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("jojoldu@gmail.com")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }

    @Test
    public void 게시글목록_출력하기() {
        //given
        postsRepository.save(Posts.builder()
                .title("테스트 게시글1")
                .content("테스트 본문1")
                .author("khjzzm@gmail.com")
                .build());

        postsRepository.save(Posts.builder()
                .title("테스트 게시글2")
                .content("테스트 본문2")
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<PostsMainResponseDto> postsList = postsService.findAllDesc();

        //then
        PostsMainResponseDto posts = postsList.get(0);
        System.out.println(posts);

        /*
        assertThat(posts.getTitle(), is("테스트 게시글2"));
        assertThat(posts.getAuthor(),is("jojoldu@gmail.com"));

        PostsMainResponseDto posts2 = postsList.get(1);
        assertThat(posts2.getTitle(), is("테스트 게시글1"));
        assertThat(posts2.getAuthor(),is("khjzzm@gmail.com"));

        PostsMainResponseDto posts3 = postsList.get(2);
        assertThat(posts3.getTitle(), is("테스트2"));
        assertThat(posts3.getAuthor(),is("test2@gmail.com"));

        PostsMainResponseDto posts4 = postsList.get(3);
        assertThat(posts4.getTitle(), is("테스트1"));
        assertThat(posts4.getAuthor(),is("test1@gmail.com"));
        */

    }
}