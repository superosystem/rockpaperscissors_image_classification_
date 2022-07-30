package com.gusrylmubarok.shop.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "authorizes")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authorize implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authorized")
    private boolean authorized;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "message")
    private String message;

    @Column(name = "error")
    private String error;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order", referencedColumnName = "id")
    private Order order;
}
