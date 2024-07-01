package org.anest.mystore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_detail")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_detail_id")
    private Long id;

    @Column(name = "gender", length = 2)
    private int gender;

    @Column(name = "dob", length = 11)
    private String dob;

    @Column(name = "mobile", length = 15, unique = true)
    private String mobile;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public String getGenderAsString() {
        return switch (gender) {
            case 0 -> "Nữ";
            case 1 -> "Nam";
            case 2 -> "Khác";
            default -> "Chưa xác định";
        };
    }
}
