package kim.zzang.webservice.domain.posts;

import kim.zzang.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "post")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POST_ID")
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String imagePath;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "post")
    private List<HashTag> hashTags = new ArrayList<HashTag>();

    void addHashTag(HashTag hashTag){
        this.hashTags.add(hashTag);
    }

    void removeHashTag(HashTag hashTag){
        this.hashTags.remove(hashTag);
    }

    @Builder
    public Post(Long id, String title, String content, String author, String imagePath) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.imagePath = imagePath;
    }
}