package ru.study.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ru.study.models.MedicalRecEntity;
import ru.study.models.dto.MedicalRecRequest;
import ru.study.repositories.MedicalRepository;

import java.util.List;


@Stateless
public class MedicalRecService {
    @Inject
    private MedicalRepository medicalRepository;

    public List<MedicalRecEntity> getAll() {
        return medicalRepository.findAll();
    }

    public void create(MedicalRecRequest medicalrecRequest) {
        MedicalRecEntity medrec = new MedicalRecEntity(
                medicalrecRequest.getId_post(),
                medicalrecRequest.getId(),
                medicalrecRequest.getId_patient(),
                medicalrecRequest.getVisit_date(),
                medicalrecRequest.getDiagnosis(),
                medicalrecRequest.getPrescription()
        );
        medicalRepository.persist(medrec);
    }

    public void delete(int medrecId) {
        medicalRepository.delete(medrecId);
    }

}















