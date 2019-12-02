package kim.zzang.webservice.dto.posts;

import kim.zzang.webservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsUpdateRequestDto(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .id(id)
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}