package com.study.controller;

import com.study.models.Houses;
import com.study.models.EventType;
import com.study.models.Model;
import com.study.repos.HouseRepository;
import com.study.services.senders.JmsSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(
        value = "api",
        produces = {"application/xml", "application/json"}
)
public class HouseController {
    @Autowired
    HouseRepository houseRepository;

    @Autowired
    JmsSenderService jmsSenderService;

    @GetMapping("/house")
    public Iterable<Houses> getHouse() {
        return houseRepository.findAll();
    }

    @GetMapping("/house/{id}")
    public @ResponseBody Optional<Houses> getHouse(@PathVariable int id) {
        return houseRepository.findById(id);
    }

    @PostMapping("/house")
    public @ResponseBody Houses createHouse(@RequestBody Houses house) {
        var house = houseRepository.save(house);
        jmsSenderService.sendEvent(house, EventType.CREATE, Model.Houses);
        return house;
    }

    @DeleteMapping("/house/{id}")
    public @ResponseBody void deleteHouse(@PathVariable int id) {
        var house = houseRepository.findById(id);
        if (house.isPresent()){
            jmsSenderService.sendEvent(house, EventType.DELETE, Model.Houses);
            houseRepository.deleteById(id);
        }
    }


    @PutMapping("/house/{id}")
    public @ResponseBody Houses updateHouse(@RequestBody Houses newHouse, @PathVariable Integer id) {
        jmsSenderService.sendEvent(houseRepository.findById(id), EventType.UPDATE, Model.Houses);

        return houseRepository.findById(id)
                .map(houses -> {
                    houses.setId_house(newHouse.getId_house());
                    houses.setStreet(newHouse.getStreet());
                    return houseRepository.save(houses);
                })
                .orElseGet(() -> {
                    return houseRepository.save(newHouse);
                });
    }
}
