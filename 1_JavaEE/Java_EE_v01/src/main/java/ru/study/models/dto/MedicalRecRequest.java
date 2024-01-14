package ru.study.models.dto;

import lombok.Data;

@Data
public class MedicalRecRequest {
    private int id_post;
    private int id;
    private int id_patient;
    private String visit_date;
    private String diagnosis;
    private String prescription;

}
