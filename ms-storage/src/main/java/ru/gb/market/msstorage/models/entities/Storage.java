package ru.gb.market.msstorage.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.market.msproduct.models.entities.ProductItem;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "storages")
@Data
@NoArgsConstructor
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    //private List<ProductItem> productItems;
}
