package com.study.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "houses")
public class Houses {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "id_house")
    private int id_house;
}
