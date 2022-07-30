package com.gusrylmubarok.shop.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;

    @Column(name = "unit_price")
    private BigDecimal price;

    @Column(name = "quantity")
    private int quantity;

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private List<Cart> carts = new ArrayList<>();

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

}
