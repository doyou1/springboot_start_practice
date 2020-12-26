package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberReponsitory;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberReponsitory memberReponsitory;

    @Autowired
    public MemberService(MemberReponsitory memberRepository) {
        this.memberReponsitory = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member); // 중복 회원 검출
        memberReponsitory.save(member);
        return member.getId();
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberReponsitory.findAll();
    }

    /**
     *  특정 회원 조회
     * @param memberId
     * @return Member Object
     */
    public Optional<Member> findOne(Long memberId) {
        return memberReponsitory.findById(memberId);
    }

    /**
     * 중복 확인 method
     * @param member
     */
    private void validateDuplicateMember(Member member) {
        memberReponsitory.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
