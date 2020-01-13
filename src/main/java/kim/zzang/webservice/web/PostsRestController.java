package kim.zzang.webservice.web;

import kim.zzang.webservice.domain.posts.Posts;
import kim.zzang.webservice.dto.posts.PostsMainResponseDto;
import kim.zzang.webservice.dto.posts.PostsSaveRequestDto;
import kim.zzang.webservice.dto.posts.PostsUpdateRequestDto;
import kim.zzang.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = {"*"})
public class PostsRestController {

    private PostsService postsService;

    @GetMapping("/api/proxy")
    public String hello() {
        return "Proxy Test";
    }

    @GetMapping("/api/list")
    public List<PostsMainResponseDto> list() {
        return postsService.findAllDesc();
    }

    @PostMapping("/api/insert")
    public void insertPosts(@RequestBody PostsSaveRequestDto dto){
        postsService.insert(dto);
    }
    
    @PostMapping("/api/update")
    public void updatePosts(@RequestBody PostsUpdateRequestDto dto){
        postsService.update(dto);
    }

    @GetMapping("/api/findByAuthor")
    public List<Posts> findByAuthor(@RequestParam String author){
        return postsService.findByAuthor(author);
    }

    @GetMapping("/api/findById")
    public Optional<Posts> findById(@RequestParam Long id){
        return postsService.findById(id);
    }

    @GetMapping("/api/delete")
    public void deletePosts(@RequestParam Long id){
        postsService.delete(id);
    }

    @GetMapping("/api/deletes")
    public void deleteAllByIdInQuery(@RequestParam List<Long> ids){
        postsService.deleteAllByIdInQuery(ids);
    }


}