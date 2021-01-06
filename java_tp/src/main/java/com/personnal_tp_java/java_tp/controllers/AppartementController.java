package com.personnal_tp_java.java_tp.controllers;

import com.personnal_tp_java.java_tp.models.Appartement;
import com.personnal_tp_java.java_tp.models.Residence;
import com.personnal_tp_java.java_tp.JavaTpApplication;
import com.personnal_tp_java.java_tp.services.AppartementService;
import com.personnal_tp_java.java_tp.model.Service;
import com.personnal_tp_java.java_tp.service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class AppartementController {
    AppartementService appartementService;

    public AppartementController(AppartementService appartementService) {
        this.appartementService = appartementService;
    }

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/appartements")
    @ResponseStatus(HttpStatus.OK)
    public List<Appartement> getAllAppartements() {
        return appartementService.getAllAppartements();
    }


    @PostMapping("/appartement/create/{name}/{surface}/{nb_couchage}/{equipement_bebe}/{climatisation}/{residence_id}")
    @ResponseStatus(HttpStatus.OK)
    public Appartement createAppartement(@PathVariable String name, @PathVariable int surface,
                                         @PathVariable int nb_couchage, @PathVariable boolean equipement_bebe,
                                         @PathVariable boolean climatisation, @PathVariable Long residence_id) {
        Appartement appModif = appartementService.createApp(name, surface, nb_couchage, equipement_bebe, climatisation, residence_id);
        return appModif;

    }


    @PutMapping("/appartement/update/{id}/{name}/{surface}/{nb_couchage}/{equipement_bebe}/{climatisation}/{residence_id}")
    @ResponseStatus(HttpStatus.OK)
    public Appartement updateAppartement(@PathVariable Long id, @PathVariable String name, @PathVariable int surface,
                                         @PathVariable int nb_couchage, @PathVariable boolean equipement_bebe,
                                         @PathVariable boolean climatisation, @PathVariable Long residence_id) {
        Appartement appModif = appartementService.updateApp(id, name, surface, nb_couchage, equipement_bebe, climatisation, residence_id);
        return appModif;

    }

    @DeleteMapping("/appartement/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAppartement(@PathVariable Long id) {
        appartementService.deleteApp(id);
    }
}