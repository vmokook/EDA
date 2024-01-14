package com.study.repos;

import com.study.models.Apartment;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends CrudRepository<Apartment, Integer> {
}
