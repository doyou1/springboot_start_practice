package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

    //JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
    //  methods명으로 쿼리를 설정할 수 있음
    //    Optional<Member> findByNameAndId(String name, Long id);
    
    // 동적쿼리의 경우는 Querydsl 라이브러리를 활용함
    
    // 실무에선 JPA, Spring DATA JPA, Querydsl, JdbcTemplate 섞어서 활용
}
