package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    //period
    @Embedded //생략 가능
    private Period workPeriod;

    //address
    @Embedded //생략 가능
    private Address homeAddress;

    @Embedded //생략 가능
    @AttributeOverrides({ // 컬럼 명 속성 재정의
            @AttributeOverride(name = "city", column = @Column(name ="WORK_CITY")),
            @AttributeOverride(name = "street", column = @Column(name ="WORK_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name ="WORK_ZIPCODE"))
    })
    private Address workAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}
