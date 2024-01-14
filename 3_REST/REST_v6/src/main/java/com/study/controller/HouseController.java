package com.study.controller;

import com.study.models.Houses;
import com.study.repos.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25

import java.util.Optional;

@RestController
@RequestMapping(
        value = "api",
        produces = {"application/xml", "application/json"}
)
<<<<<<< HEAD
=======

>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
public class HouseController {
    @Autowired
    HouseRepository houseRepository;

    @GetMapping("/house")
    public Iterable<Houses> getHouse() {
        return houseRepository.findAll();
    }

    @GetMapping("/house/{id}")
<<<<<<< HEAD
    public @ResponseBody Optional<Houses> getHouse(@PathVariable int id) {
        return houseRepository.findById(id);
    }

    @PostMapping("/house")
    public @ResponseBody Houses createHouse(@RequestBody Houses house) {
        var house = houseRepository.save(house);
        return house;
    }

    @DeleteMapping("/house/{id}")
    public @ResponseBody void deleteHouse(@PathVariable int id) {
        var house = houseRepository.findById(id);
        if (house.isPresent()){
            houseRepository.deleteById(id);
        }
    }


    @PutMapping("/house/{id}")
    public @ResponseBody Houses updateHouse(@RequestBody Houses newHouse, @PathVariable Integer id) {
        return houseRepository.findById(id)
                .map(houses -> {
                    houses.setId_house(newHouse.getId_house());
                    houses.setStreet(newHouse.getStreet());
                    return houseRepository.save(houses);
                })
                .orElseGet(() -> {
                    return houseRepository.save(newHouse);
                });
=======
    public @ResponseBody Optional<Houses> getHouse(@PathVariable int id_number) {
        return houseRepository.findById(id_number);
    }
    @PostMapping("/debtor")
    public @ResponseBody Houses createHouse(Houses house) {
        return houseRepository.save(house);
    }

    @DeleteMapping("/debtor/{id_number}")
    public @ResponseBody void deleteHouse(@PathVariable int id_number) {
        houseRepository.deleteById(id_bumber);
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    }
}
