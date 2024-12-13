package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            // 변경 감지
            // 영속
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");

            System.out.println("========");
            // 트랜잭션을 지원하는 쓰기 지연
//            // 영속
//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L,"B");
//
//            //영속성 컨텍스트에 쌓임
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("============");
//            //커밋하는 시점에 db로 날라감
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
