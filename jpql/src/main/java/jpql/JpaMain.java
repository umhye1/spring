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

            Team team = new Team();
            em.persist(team);

            Member member = new Member();
            member.setUsername("관리자");
            member.setTeam(team);

            em.persist(member);

            Member member2 = new Member();
            member2.setUsername("관리자2");

            em.persist(member2);

            em.flush();
            em.clear();

//            String query = "select concat('a','b') from Member m";
//            String query = "select substring(m.username,2,3) from Member m";
//            String query = "select locate('de','abcdefg') from Member m";
            String query = "select size(t.members) From Team t";
            List<Integer> result = em.createQuery(query, Integer.class).getResultList();

            for (Integer s : result) {
                System.out.println("s = " + s);
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
