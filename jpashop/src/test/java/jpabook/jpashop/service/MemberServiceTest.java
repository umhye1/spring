package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
@SpringBootTest     //Autowired 사용시 필수적
@Transactional
@ActiveProfiles("test")
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    public void 회원가입() throws Exception{
        // given
        Member member = new Member();
        member.setName("Kim");

        // when
        em.flush();
        long savedId = memberService.join(member);

        // then
        assertEquals(member,memberRepository.findOne(savedId));

    }

    //try-catch로 예외 처리 가능하나, jnuit4에선 @Test(expected = IllegalStateException.class)로 간단하게 예외처리 가능
    // junit5에서는 assertThrows 사용
    @Test
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("Kim");

        Member member2 = new Member();
        member2.setName("Kim");

        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2); // 예외가 발생해야 한다
        });

        //then
//        fail("예외가 발생해야 한다");
//        테스트에서 assertThrows를 사용하여 예외가 발생 검증 시 : fail()를 제거
//        assertThrows가 예외 발생을 검증하므로, fail이 불필요하게 실패를 발생. 다른 경우에서 의도적으로 실패를 유발할 때 사용
    }

}