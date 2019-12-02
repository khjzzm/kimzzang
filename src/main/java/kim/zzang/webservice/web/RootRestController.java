package kim.zzang.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@AllArgsConstructor
public class RootRestController {

    private Environment env;

    // @Autowired, setter, 생성자 이중 가장 권장하는 방식이 생성자로 주입받는 방식이다.
    // @AllArgsConstructor 는 모든 필드를 인자값으로 하는 생성자를 만들어준다.
    // public WebRestController(PostsService postsService) {
    //     this.postsService = postsService;
    // }

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @GetMapping("/profile")
    public String getProfile () {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }
}
