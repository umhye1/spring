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

            em.flush();
            em.clear();

            // 엔티티 프로젝션
            List<Team> result = em.createQuery("select t from Member m join m.team t", Team.class)
                    .getResultList();

            //임베디드 프로젝션
            em.createQuery("select o.address from Order o", Address.class)
                    .getResultList();

            //스칼라 타입 프로젝션
            List resultList = em.createQuery("select m.username, m.age from Member m")
                    .getResultList();

            //프로젝션 - 여러 값 조회 : 2. object[] 타입으로 조회
            Object o = resultList.get(0);
            // 타입캐스팅
            Object[] result1 = (Object[]) o;
            System.out.println("username = " + result1[0]);
            System.out.println("age = " + result1[1]);


            //프로젝션 - 여러 값 조회 : 타입캐스팅 없이
            List<Object[]> resultList2 = em.createQuery("select m.username, m.age from Member m")
                    .getResultList();

            //프로젝션 - 여러 값 조회 : 3. new
            List<MemberDTO> resultList3 = em.createQuery("select new jpql.MemberDTO(m.username, m.age)from Member m", MemberDTO.class)
                    .getResultList();

            MemberDTO memberDTO = resultList3.get(0);
            System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
            System.out.println("memberDTO = " + memberDTO.getAge());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
