package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Item;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@DiscriminatorValue("B")
@Entity
public class Book extends Item {
    private String author;
    private String isbn;
}
