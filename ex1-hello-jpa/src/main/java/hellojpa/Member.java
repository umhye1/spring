package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

   @Column(name = "USERNAME")
   private String username;

    @ManyToOne //(n:1)
    @JoinColumn(name = "TEAM_ID") //외래키 매핑
    private Team team;

    public Long getId() {   return id;  }

    public void setId(Long id) {    this.id = id;   }

    public String getUsername() {   return username;    }

    public void setUsername(String username) {  this.username = username;   }

    public Team getTeam() { return team;    }

    public void setTeam(Team team) {    this.team = team;   }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", team=" + team +
                '}';
    }
}
