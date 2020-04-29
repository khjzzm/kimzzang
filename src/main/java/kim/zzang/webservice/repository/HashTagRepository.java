package kim.zzang.webservice.repository;

import kim.zzang.webservice.domain.posts.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagRepository extends JpaRepository<HashTag, Integer> {
}
