package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    //enum type
    // ordinal 사용시 숫자로 상태를 반영하기 때문에 상태가 늘어나는 경우 장애남
    // string 사용할 것
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //READY, COMP,
}
