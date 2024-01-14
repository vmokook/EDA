package com.study.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "email")
public class Email {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "receiver", unique=true)
    private String receiver;

    @NonNull
    @Column(name = "models")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Model.class, fetch = FetchType.EAGER)
    @CollectionTable
    private List<Model> models;

    @NonNull
    @Column(name = "events")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = EventType.class, fetch = FetchType.EAGER)
    @CollectionTable
    private List<EventType> events;
}
