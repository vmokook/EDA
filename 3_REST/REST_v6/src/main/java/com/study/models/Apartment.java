package com.study.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "apartments")
public class Apartment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_apar")
    private int id_apar;

    @Column(name = "id_house")
    private int id_dorm;
}

