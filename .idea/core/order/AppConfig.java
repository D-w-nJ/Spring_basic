package hello.core.order;

import hello.core.member.MemberService;
import hello.core.member.MemberserviceImpl;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberSercive() {
        return new MemberserviceImpl(new MemoryMemberRepository());
    }
}
