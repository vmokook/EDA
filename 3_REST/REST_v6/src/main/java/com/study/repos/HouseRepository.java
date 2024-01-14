package com.study.repos;

import com.study.models.Houses;
import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends CrudRepository<Houses, Integer> {

}
