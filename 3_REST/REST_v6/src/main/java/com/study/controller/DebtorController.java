package com.study.controller;

import com.study.models.Debtor;

import com.study.repos.DebtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(
        value = "api",
        produces = {"application/xml", "application/json"}
)
public class DebtorController {
    @Autowired
    DebtorRepository debtorRepository;

    @GetMapping("/debtor")
    public @ResponseBody Iterable<Debtor> getDebtor() {
        return debtorRepository.findAll();
    }

    @GetMapping("/debtor/{id_number}")
    public @ResponseBody Optional<Debtor> getDebtor(@PathVariable int id_number) {
        return debtorRepository.findById(id_number);
    }

    @PostMapping("/debtor")
    public @ResponseBody Debtor createDebtor(@RequestBody Debtor debtor) {
        var debtor_ = debtorRepository.save(debtor);
        return debtor_;
    }

    @DeleteMapping("/debtor/{id_number}")
    public @ResponseBody void deleteDebtor(@PathVariable int id_number) {
        var debtor = debtorRepository.findById(id_number);
        if (debtor.isPresent()){
            debtorRepository.deleteById(id_number);
        }
    }

    @PutMapping("/debtor/{id}")
    public @ResponseBody Debtor updateDebtor(@RequestBody Debtor newDebtor, @PathVariable Integer id) {
        return debtorRepository.findById(id)
                .map(debtor -> {
                    if (newDebtor.getId_house() != 0) {
                        debtor.setId_house(newDebtor.getId_house());
                    }
                    if (newDebtor.getSummy() != 0) {
                        debtor.setSummy(newDebtor.getSummy());
                    }
                    return debtorRepository.save(debtor);
                })
                .orElseGet(() -> {
                    return debtorRepository.save(newDebtor);
                });
    }
}

