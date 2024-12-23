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

    @ManyToOne
    @JoinColumn(name  = "TEAM_ID" ,insertable = false, updatable = false) // 읽기 전용 필드
    private Team team;

    @OneToOne
    @JoinColumn(name = "Locker_ID")
    private Locker locker;


    public Long getId() {   return id;  }

    public void setId(Long id) {    this.id = id;   }

    public String getUsername() {   return username;    }

    public void setUsername(String username) {  this.username = username;   }

}
