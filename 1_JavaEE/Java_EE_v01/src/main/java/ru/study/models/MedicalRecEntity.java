package ru.study.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medical_records")
public class MedicalRecEntity{
    @Id
    @Column(name = "id_post")
    private int id_post;

    @Id
    @Column(name = "id_medrec")
    private int id;

    @Id
    @Column(name = "id_patient")
    private int id_patient;

    @Column(name = "visit_date")
    private String visit_date;

    @Column(name = "diagnosis", columnDefinition = "TEXT")
    private String diagnosis;

    @Column(name = "prescription", columnDefinition = "TEXT")
    private String prescription;
}

