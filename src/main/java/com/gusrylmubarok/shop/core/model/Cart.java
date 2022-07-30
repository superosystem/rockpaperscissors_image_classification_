package com.gusrylmubarok.shop.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cart_item",
        joinColumns = @JoinColumn(name = "id_cart"),
        inverseJoinColumns = @JoinColumn(name = "id_item"))
    private List<Item> items = new ArrayList<>();
}
