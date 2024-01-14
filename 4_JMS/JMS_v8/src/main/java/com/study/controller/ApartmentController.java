package com.study.controller;

import com.study.models.EventType;
import com.study.models.Model;
import com.study.models.Apartment;
import com.study.repos.ApartmentRepository;
import com.study.services.senders.JmsSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "api",
        produces = {"application/xml", "application/json"}
)
public class ApartmentController {
    @Autowired
    ApartmentRepository apartmentRepository;
    @Autowired
    JmsSenderService jmsSenderService;

    @GetMapping("/apartment")
    public Iterable<Apartment> getApartment() {
        return apartmentRepository.findAll();
    }

    @PostMapping("/apartment")
    public @ResponseBody Apartment createApartment(@RequestBody Apartment apartment) {
        var apartment_ = apartmentRepository.save(apartment);
        jmsSenderService.sendEvent(apartment_, EventType.CREATE, Model.Apartment);
        return apartment;
    }

    @DeleteMapping("/apartment/{id}")
    public @ResponseBody void deleteApartment(@PathVariable int id) {
        var apartment = apartmentRepository.findById(id);
        if (apartment.isPresent()){
            jmsSenderService.sendEvent(apartment, EventType.DELETE, Model.Apartment);
            apartmentRepository.deleteById(id);
        }
    }

    @PutMapping("/apartment/{id}")
    public @ResponseBody Apartment updateApartment(@RequestBody Apartment newApartment, @PathVariable Integer id) {
        var apartment_ = apartmentRepository.findById(id)
                .map(apartment -> {
                    apartment.setId_apar(newApartment.getId_apar());
                    apartment.setId_house(newApartment.getId_house());
                    return apartmentRepository.save(apartment);
                })
                .orElseGet(() -> {
                    return apartmentRepository.save(newApartment);
                });

        jmsSenderService.sendEvent(apartment_, EventType.UPDATE, Model.Apartment);
        return apartment_;
    }
}