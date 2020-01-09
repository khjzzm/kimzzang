package kim.zzang.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kim.zzang.webservice.domain.posts.Posts;

import java.util.List;
import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long>{

    @Query(value = "SELECT p FROM Posts p ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();

    List<Posts> findByAuthor(String author);

    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query("delete from Posts p where p.id in :ids")
    void deleteAllByIdInQuery(@Param("ids") List<Long> ids);
}