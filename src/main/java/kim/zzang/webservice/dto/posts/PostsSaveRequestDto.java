package kim.zzang.webservice.dto.posts;

import kim.zzang.webservice.domain.posts.HashTag;
import kim.zzang.webservice.domain.posts.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private List<HashTag> hashtag = new ArrayList<>();

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}