package ru.study.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.study.models.MedicalRecEntity;
import ru.study.models.PostsEntity;

import java.util.List;

@Stateless
public class PostsRepository {
    @PersistenceContext
    private EntityManager em;

    public Iterable<PostsEntity> findAll() {
        return em.createQuery("select i from PostsEntity i", PostsEntity.class).getResultList();
    }

    public PostsEntity findByIdPost(int id_post) {
        return em.createQuery("select i from PostsEntity i where i.id_post = :id_post",
                        PostsEntity.class).setParameter("id_post", id_post)
                .getSingleResult();
    }

    public Iterable<PostsEntity> findByMedrec(String medrec) {
        return em.createQuery("select i from PostsEntity i where i.medrec = :medrec",
                        PostsEntity.class).setParameter("medrec", medrec).getResultList();
    }

    public void persist(PostsEntity entity) {
        em.persist(entity);
    }

    public void delete(String medical_center, int id_post) {
        em.createQuery("delete from MedicalRecEntity where id_post = :id_post")
                .setParameter("id_post", id_post)
                .executeUpdate();

        em.createQuery("delete from PatientEntity where id_post = :id_post")
                .setParameter("id_post", id_post)
                .executeUpdate();

        em.createQuery("delete from PostsEntity where medical_center = :medical_center")
                .setParameter("medical_center", medical_center)
                .executeUpdate();
    }
}
