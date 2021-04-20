package ru.gb.market.msorder.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.market.msproduct.models.entities.ProductItem;
import ru.gb.msauth.models.entities.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "orders_proditems",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "proditem_id")
    )
    private List<ProductItem> productItems;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus orderStatus;

}
