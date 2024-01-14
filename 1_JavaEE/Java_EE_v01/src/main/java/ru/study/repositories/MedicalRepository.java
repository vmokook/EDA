package ru.study.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.study.models.MedicalRecEntity;

import java.util.List;

@Stateless
public class MedicalRepository {
    @PersistenceContext
    private EntityManager em;

    public List<MedicalRecEntity> findAll() {
        return em.createQuery("select i from MedicalRecEntity i",
                MedicalRecEntity.class).getResultList();
    }

    public MedicalRecEntity findByIdCard(int id) {
        return em.createQuery("select i from MedicalRecEntity i where i.id = :id",
                        MedicalRecEntity.class).setParameter("id", id)
                .getSingleResult();
    }

    public List<MedicalRecEntity> findByIdDorm(int id) {
        return em.createQuery("select i from MedicalRecEntity i where i.id_dorm = :id",
                        MedicalRecEntity.class).setParameter("id", id)
                .getResultList();
    }

    public void persist(MedicalRecEntity entity) {
        em.persist(entity);
    }

    public void delete(int medrecId) {
        MedicalRecEntity entity = em.find(MedicalRecEntity.class, medrecId);
        em.remove(entity);
    }
}