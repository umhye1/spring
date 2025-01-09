package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            //반환 타입이 명확 -> TypeQuery
            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);

            // 반환타입 명확하지 않을 때 query
            Query query3 = em.createQuery("select m.username, m.age from Member m");

            // 결과조회 - getResultList()
            List<Member> resultList = query.getResultList();
            for (Member member1 : resultList) {
                System.out.println("member1 = " + member1);
            }

            // getSingleResult()
            Member result = em.createQuery("select m from Member m where m.username =: username", Member.class)
                    .setParameter("username", "member1")// 반환타입 명확하지 않을 때 query
                    .getSingleResult();
            System.out.println("singleResult.getUsername() = " + result.getUsername());


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
