package kim.zzang.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kim.zzang.webservice.domain.shop.Member;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long>{

//    List<Member> findByMember(String id);

    @Query(value = "SELECT m FROM Member m where m.name = :name")
    List<Member> findByName(@Param("name") String name);
}