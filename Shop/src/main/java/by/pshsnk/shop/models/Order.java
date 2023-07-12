package by.pshsnk.shop.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

}
