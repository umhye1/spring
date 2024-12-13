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
            // 준영속 상태 - detach
            // 영속
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");
//
//            //영속성 컨텍스트에서 관리하지마! -> 준영속 상태
//            em.detach(member);
//            System.out.println("========");

            // 준영속 상태 - clear
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            //영속성 컨텍스트에서 관리하지마! -> 준영속 상태  ,1차 캐쉬 없음
            em.clear();
            Member member2 = em.find(Member.class, 150L);
            System.out.println("========");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
