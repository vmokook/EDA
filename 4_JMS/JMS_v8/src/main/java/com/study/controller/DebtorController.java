package com.study.controller;

import com.study.models.EventType;
import com.study.models.Model;
import com.study.models.Debtor;
import com.study.repos.DebtorRepository;
import com.study.services.senders.JmsSenderService;
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

    @Autowired
    JmsSenderService jmsSenderService;

    @GetMapping("/debtor")
    public @ResponseBody Iterable<Debtor> getDebtors() {
        return debtorRepository.findAll();
    }

    @GetMapping("/debtor/{id_number}")
    public @ResponseBody Optional<Debtor> getDebtor(@PathVariable int id_number) {
        return debtorRepository.findById(id_number);
    }

    @PostMapping("/debtor")
    public @ResponseBody Debtor createDebtor(@RequestBody Debtor debtor) {
        var debtor_ = debtorRepository.save(debtor);
        jmsSenderService.sendEvent(debtor_, EventType.CREATE, Model.Debtor);
        return debtor_;
    }

    @DeleteMapping("/debtor/{id_number}")
    public @ResponseBody void deleteDebtor(@PathVariable int id_number) {
        var debtor = debtorRepository.findById(id_number);
        if (debtor.isPresent()){
            jmsSenderService.sendEvent(debtor, EventType.DELETE, Model.Debtor);
            debtorRepository.deleteById(id_number);
        }
    }

    @PutMapping("/debtor/{id}")
    public @ResponseBody Debtor updateDebtor(@RequestBody Debtor newDebtor, @PathVariable Integer id) {
        jmsSenderService.sendEvent(debtorRepository.findById(id), EventType.UPDATE, Model.Debtor);
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

