package kim.zzang.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kim.zzang.webservice.domain.posts.Post;

import java.util.List;
import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Post, Long>{

    @Query(value = "SELECT p FROM Post p ORDER BY p.id DESC")
    Stream<Post> findAllDesc();

    List<Post> findByAuthor(String author);

    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query("delete from Post p where p.id in :ids")
    void deleteAllByIdInQuery(@Param("ids") List<Long> ids);
}