package hello.core.order;


import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    @Autowired  private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;

//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    //AppConfig에서 OrderServiceImpl에 MemoryMemberRepository, FixDiscountPolicy 할당함
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Autowired
    public void init(MemberRepository memberRepository,DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // OrderService 입장에서는 결과만 반환해달라고 설계
    // 단일 책임 원칙 잘 지킴
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        // 최종 생성된 주문을 반환
        return new Order(memberId, itemName,itemPrice,discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
