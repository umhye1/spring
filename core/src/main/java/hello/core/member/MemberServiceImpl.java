package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //가입하고 회원을 찾으려면 MemberRepository 인터페이스가 필요
    // 구현 객체를 선택해야함
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        //join에서 save 호출시 : 다형성에 의해 MemoryMemberRepository에 있는 인터페이스가 아니라
        // MemoryMemberRepository에 있는 override된 save가 호출됨
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
