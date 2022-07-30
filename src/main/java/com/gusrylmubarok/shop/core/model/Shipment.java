package com.gusrylmubarok.shop.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "shipments")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shipment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "est_delivery_date")
    private Timestamp estDeliveryDate;

    @Column(name = "carrier", length = 32)
    private String carrier;
}
