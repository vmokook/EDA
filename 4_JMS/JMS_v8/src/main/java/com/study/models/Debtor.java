package com.study.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "debtors")
public class Debtor implements Serializable {
    @Id
    @Column(name = "id_number")
    private int id_number;

    @Column(name = "id_house")
    private int id_house;

    @Column(name = "id_apar")
    private int id_apar;

    @Column(name = "full_name", unique = true)
    private String full_name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "summy")
    private int summy;
}

