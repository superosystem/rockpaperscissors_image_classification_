package com.gusrylmubarok.shop.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cards")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "expires")
    private String expires;

    @Column(name = "cvv")
    private String cvv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Order> orders;
}
