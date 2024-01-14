package ru.study.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ru.study.models.PostsEntity;
import ru.study.models.dto.PostsRequest;
import ru.study.repositories.PostsRepository;

@Stateless
public class PostsService {
    @Inject
    private PostsRepository postsRepository;

    public Iterable<PostsEntity> getAll() {
        return postsRepository.findAll();
    }

    public void create(PostsRequest postsRequest) {
        PostsEntity post = new PostsEntity(
                postsRequest.getId_post(),
                postsRequest.getMedrec()
        );

        postsRepository.persist(post);
    }

    public void delete(String medical_center, int id_post) {
        postsRepository.delete(medical_center, id_post);
    }
}
