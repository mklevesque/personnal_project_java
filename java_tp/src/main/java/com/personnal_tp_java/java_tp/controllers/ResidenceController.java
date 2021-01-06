package com.personnal_tp_java.java_tp.controllers;

import com.personnal_tp_java.java_tp.models.Residence;
import com.personnal_tp_java.java_tp.JavaTpApplication;
import com.personnal_tp_java.java_tp.model.Service;
import com.personnal_tp_java.java_tp.service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ResidenceController {
    ResidenceService residenceservice;

    public ResidenceController(ResidenceService residenceservice) {
        this.residenceservice = residenceservice;
    }

    @GetMapping("/residence")
    @ResponseStatus(HttpStatus.OK)
    public List<Residence> getResidence() { return residenceservice.getResidence(); }

    @PostMapping("/residence/create/{name}/{pays}/{region}/{adresse}/{gps}/{lieu}")
    @ResponseStatus(HttpStatus.OK)
    public Residence createResidence(@PathVariable String name, @PathVariable String pays, @PathVariable String region, @PathVariable String adresse, @PathVariable String gps, @PathVariable String lieu) {
        return residenceservice.createResidence(name, pays, region, adresse, gps, lieu);
    }

    @PutMapping("/residence/update/{id}/{name}/{pays}/{region}/{adresse}/{gps}/{lieu}")
    @ResponseStatus(HttpStatus.OK)
    public Residence updateResidence(@PathVariable Long id, @PathVariable String name, @PathVariable String pays, @PathVariable String region, @PathVariable String adresse, @PathVariable String gps, @PathVariable String lieu) {
        return residenceservice.updateResidence(id, name, pays, region, adresse, gps, lieu);
    }

    @DeleteMapping("/residence/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteResidence(@PathVariable Long id) {
        residenceservice.deleteResidence(id);
    }

}