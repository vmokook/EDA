package ru.study.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.study.models.PatientEntity;

import java.util.List;

@Stateless
public class PatientRepository {
    @PersistenceContext
    private EntityManager em;

    public List<PatientEntity> findAll() {
        return em.createQuery("select i from PatientEntity i ", PatientEntity.class).getResultList();
    }

    public List<PatientEntity> findByIdRoom(int id_post) {
        return em.createQuery("select i from PatientEntity i where i.id_post = :id_post", PatientEntity.class)
                .setParameter("id_post", id_post)
                .getResultList();
    }

    public void persist(PatientEntity entity) {
        em.persist(entity);
    }

    public void delete(int id_post, int id_patient) {
        em.createQuery("delete from MedicalRecEntity where id_patient = :id_patient").setParameter("id_patient", id_patient).executeUpdate();

        PatientEntity entity = (PatientEntity) em.createQuery("select i from PatientEntity i where i.id_post = :value1 and i.id_post= :value2")
                .setParameter("value1", id_post)
                .setParameter("value2", id_post)
                .getSingleResult();
        em.remove(entity);
    }
}
