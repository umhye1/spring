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

            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();

//            String query = "select m From Member m";
//            List<Member> result = em.createQuery(query, Member.class).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member);
//                //회원 1, 팀A (sql)
//                //회원 2, 팀A (1차 캐시)
//                //회원 3, 팀B (sql)
//
//                //회원 100명 = 1 + N 문제
//             }

            // 패치 조인
            String query = "select m From Member m join fetch m.team";
            List<Member> result = em.createQuery(query, Member.class).getResultList();

            for (Member member : result) {
                System.out.println("member = " + member);
                //패치조인으로 회원과 팀을 함께 조회해서 지연 로딩 x
            }

            //일대다 관계, 컬랙션 패치 조인 -> 뻥튀기 문제 발생 가능
            String query2 = "select t From Team t join fetch t.members";
            List<Team> result2 = em.createQuery(query2, Team.class).getResultList();

            for (Team team : result2) {
                System.out.println("team = " + team.getName() + "| members = " +team.getMembers().size());
                for (Member member : team.getMembers()) {
                    System.out.println("-> member = " + member);
                }
            }

            //distinct - 중복 제거
            String query3 = "select distinct t From Team t join fetch t.members";
            List<Team> result3 = em.createQuery(query3, Team.class).getResultList();

            for (Team team : result3) {
                System.out.println("team = " + team.getName() + "| members = " +team.getMembers().size());
                for (Member member : team.getMembers()) {
                    System.out.println("-> member = " + member);
                }
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
