package jpql;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Team team = new Team();
            em.persist(team);

            Member member = new Member();
            member.setUsername("관리자1");
            member.setTeam(team);
            em.persist(member);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            member2.setTeam(team);
            em.persist(member2);

            em.flush();
            em.clear();
// 묵시적 inner join
//            String query = "select m.team From Member m";
//            List<Team> result = em.createQuery(query, Team.class).getResultList();

//            String query = "select t.members.size From Team t";
//            Integer result = em.createQuery(query, Integer.class).getSingleResult();


            String query = "select m From t join t.members m";
            List<Collection> result = em.createQuery(query, Collection.class).getResultList();

            System.out.println("result = " + result);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
