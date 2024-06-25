package org.anest.mystore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private Long id;

    @Column(name = "color_code", nullable = false, unique = true)
    private String colorCode;

    @Column(name = "color_name", nullable = false)
    private String colorName;

    @Column(name = "color_description")
    private String colorDescription;

    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL)
    private List<Product> products;
}
