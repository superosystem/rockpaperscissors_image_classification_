package com.gusrylmubarok.shop.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 32, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", length = 32)
    private String firstName;

    @Column(name = "last_name", length = 32)
    private String lastName;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "phone", length = 16)
    private String phone;

    @Column(name = "user_status", length = 16)
    private String userStatus;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Card> cards  = new ArrayList<>();

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private Cart cart;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();
}
