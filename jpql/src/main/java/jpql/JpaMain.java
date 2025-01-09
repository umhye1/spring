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
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member");
            member.setAge(10);

            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            //내부 조인
            String query1 = "select m from Member m inner join m.team t";

            //외부 조인
            String query2 = "select m from Member m left outer join m.team t";

            //세타 조인
            String query3 = "select m from Member m,Team t where m.username = t.name";

            //on  - 조인 대상 필터링
            String query4 = "select m from Member m left join m.team on t.name = 'teamA";

            //연관관계 없는 엔티티 외부 조인
            String query5 = "select m from Member m left join Team t on m.username = t. name";

            List<Member> result = em.createQuery(query5,Member.class)
                    .getResultList();

            System.out.println("result = " + result.size());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
