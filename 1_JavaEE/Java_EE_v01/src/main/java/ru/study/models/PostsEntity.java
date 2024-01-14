package ru.study.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class PostsEntity {
    @Id
    @Column(name = "id_post")
    private int id_post;

    @Column(name = "medrec")
    private String medrec;
}
