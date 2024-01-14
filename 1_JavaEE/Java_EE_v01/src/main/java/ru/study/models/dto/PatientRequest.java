package ru.study.models.dto;

import lombok.Data;

@Data
public class PatientRequest {
    private int id_patient;

    private int id_post;

    private String first_name;

    private String last_name;

    private String birth_date;

    private String gender;
}
