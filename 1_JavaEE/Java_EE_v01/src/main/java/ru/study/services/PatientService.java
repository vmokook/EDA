package ru.study.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ru.study.models.PatientEntity;
import ru.study.models.dto.PatientRequest;
import ru.study.repositories.PatientRepository;

import java.util.List;

@Stateless
public class PatientService {
    @Inject
    private PatientRepository patientRepository;

    public List<PatientEntity> getAll() {
        return patientRepository.findAll();
    }

    public void create(PatientRequest patientRequest) {
        PatientEntity patient = new PatientEntity(
                patientRequest.getId_patient(),
                patientRequest.getId_post(),
                patientRequest.getFirst_name(),
                patientRequest.getLast_name(),
                patientRequest.getBirth_date(),
                patientRequest.getGender()
        );
        patientRepository.persist(patient);
    }

    public void delete(int id_post, int id_patient) {
        patientRepository.delete(id_post, id_patient);
    }
}


