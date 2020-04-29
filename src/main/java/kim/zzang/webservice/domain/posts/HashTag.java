package kim.zzang.webservice.domain.posts;


import lombok.Getter;

import javax.persistence.*;

@Table(name = "hashtag")
@Getter
@Entity
public class HashTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HASHTAG_ID")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String hashtag;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "POST_ID")
    private Post post;

    public void setPost(Post post) {
        if (this.post != null) {
            this.post.removeHashTag(this);
        }

        this.post = post;
        post.addHashTag(this);

    }
}
