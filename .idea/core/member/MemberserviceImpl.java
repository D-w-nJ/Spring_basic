package hello.core.member;

public class MemberserviceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberserviceImpl(MemoryMemberRepository memberRepository) {
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
}
