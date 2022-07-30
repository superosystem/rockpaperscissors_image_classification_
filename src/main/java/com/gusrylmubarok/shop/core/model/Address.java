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
@Table(name = "addresses")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "residency")
    private String residency;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "pincode")
    private String pincode;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "id_address"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users = new ArrayList<>();
}
