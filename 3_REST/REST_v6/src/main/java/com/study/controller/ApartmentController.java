package com.study.controller;

import com.study.models.Apartment;
import com.study.repos.ApartmentRepository;
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
public class ApartmentController {
    @Autowired
    ApartmentRepository apartmentRepository;

    @GetMapping("/apartment")
    public Iterable<Apartment> getApartment() {
        return apartmentRepository.findAll();
    }

<<<<<<< HEAD
    @PostMapping("/apartment")
    public @ResponseBody Apartment createApartment(@RequestBody Apartment apartment) {
        var araptment_ = apartmentRepository.save(apartment);
        return apartment;
=======
    @GetMapping("/apartment/{id}")
    public @ResponseBody Optional<Apartment> getApartment(@PathVariable int id_number) {
        return apartmentRepository.findById(id_number);
    }

    @PostMapping("/apartment")
    public @ResponseBody Apartment createApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    @DeleteMapping("/apartment/{id_number}")
    public @ResponseBody void deleteApartment(@PathVariable int id_number) {
        apartmentRepository.deleteById(id_number);
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    }

    @DeleteMapping("/apartment/{id}")
    public @ResponseBody void deleteApartment(@PathVariable int id) {
        var apartment = apartmentRepository.findById(id);
        if (apartment.isPresent()){
            apartmentRepository.deleteById(id);
        }
    }

    @PutMapping("/apartment/{id}")
    public @ResponseBody Apartment updateApartment(Apartment newApartment, @PathVariable Integer id) {
        var apartment_ = apartmentRepository.findById(id)
                .map(apartment -> {
                    apartment.setId_apar(newApartment.getId_apar());
                    apartment.setId_house(newApartment.getId_house());
                    return apartmentRepository.save(apartment);
                })
                .orElseGet(() -> {
                    return apartmentRepository.save(newApartment);
                });
        return apartment_;
    }
}