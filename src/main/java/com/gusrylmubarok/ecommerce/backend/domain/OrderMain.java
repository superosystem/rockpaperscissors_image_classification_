package com.gusrylmubarok.ecommerce.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_main")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class OrderMain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @NotEmpty
    private String buyerEmail;

    @NotEmpty
    private String buyerName;

    @NotEmpty
    private String buyerPhone;

    @NotEmpty
    private String buyerAddress;

    @NotNull
    private BigDecimal orderAmount;

    @NotNull
    @ColumnDefault("0")
    private Integer orderStatus;

    @CreationTimestamp
    private LocalDateTime createTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "orderMain")
    private Set<ProductInOrder> products = new HashSet<>();

    public OrderMain(User user) {
        this.buyerEmail = user.getEmail();
        this.buyerName = user.getName();
        this.buyerPhone = user.getPhone();
        this.buyerAddress = user.getAddress();
        this.orderAmount = user.getCart().getProducts().stream().map(item -> item
                .getProductPrice().multiply(new BigDecimal(item.getCount())))
                .reduce(BigDecimal::add).orElse(new BigDecimal(0));
        this.orderStatus = 0;
    }
}
