package org.anest.mystore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.anest.mystore.component.DefaultValues;
import org.anest.mystore.component.Settings;
import org.anest.mystore.util.FormatUtil;

import java.util.Date;
import java.util.List;

import static org.anest.mystore.constant.IConstants.*;

@Getter
@Setter
@Entity
@Table(name = "[order]")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_shipped_date")
    private Date orderShippedDate;

    @Column(name = "order_created_at", nullable = false)
    private Date orderCreatedAt;

    @Column(name = "order_discount", nullable = false)
    private double orderDiscount;

    @Column(name = "order_total_amount", nullable = false)
    private double orderTotalAmount;

    @Column(name = "order_note")
    private String orderNote;

    @Column(name = "receiver_name", nullable = false)
    private String receiverName;

    @Column(name = "receiver_mobile", nullable = false)
    private String receiverMobile;

    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress;

    @ManyToOne
    @JoinColumn(name = "order_status_id", referencedColumnName = "order_status_id")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetailList;

    public String getOrderNumber() {
        return Settings.properties.get(ORDER_PREFIX) + FormatUtil.leftPad(
                String.valueOf(id),
                Integer.parseInt(Settings.properties.get(ORDER_NUMBER_LENGTH)),
                Settings.properties.get(ORDER_NUMBER_PAD)
        );
    }
}
