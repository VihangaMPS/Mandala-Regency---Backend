package com.example.cabinservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cabin {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private BigDecimal price;

    private int guestcount;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
