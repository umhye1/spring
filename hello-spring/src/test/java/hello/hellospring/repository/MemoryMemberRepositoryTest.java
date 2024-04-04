package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result = "+(result == member));

        Assertions.assertEquals(member,result);
        ObjectAssert<Member> equalTo = org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);

    }
}