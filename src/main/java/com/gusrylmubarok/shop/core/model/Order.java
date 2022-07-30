package com.gusrylmubarok.shop.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address", referencedColumnName = "id", insertable = false, updatable = false)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_payment", referencedColumnName = "id")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "id_shipment", referencedColumnName = "id")
    private Shipment shipment;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_card", referencedColumnName = "id")
    private Card card;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "order_item",
        joinColumns = @JoinColumn(name = "id_order"),
        inverseJoinColumns = @JoinColumn(name = "id_item"))
    private List<Item> items = new ArrayList<>();

    @OneToOne(mappedBy = "order")
    private Authorize  authorize;
}
