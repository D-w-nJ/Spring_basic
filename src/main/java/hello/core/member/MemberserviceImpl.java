package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberserviceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired //생성자에 붙여주면 의존관계 주입을 자동으로 해줌 (이 경우에는 memoryMemberRepository),
    // 자동으로 ac.getBean(memoryMemberRepository.class) 들어감
    public MemberserviceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
