package com.personnal_tp_java.java_tp.service;

import com.personnal_tp_java.java_tp.models.Appartement;
import com.personnal_tp_java.java_tp.models.Residence;
import com.personnal_tp_java.java_tp.models.Service;
import com.personnal_tp_java.java_tp.JavaTpApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ResidenceService {

    private final ResidenceRepository residenceRepository;
    private AppartementRepository appartementRepository;

    public ResidenceService(ResidenceRepository residenceRepository, AppartementRepository appartementRepository) {
        this.residenceRepository = residenceRepository;
        this.appartementRepository = appartementRepository;
    }

    public List<Residence> getResidence() {
        List<Residence> residences = residenceRepository.getAllResidence();
        return residences;
    }

    public Residence createResidence(String name, String pays, String region, String adresse, String gps, String lieu) {
        Residence residence = new Residence();
        residence.setName(name);
        residence.setPays(pays);
        residence.setRegion(region);
        residence.setAdresse(adresse);
        residence.setGps(gps);
        residence.setlieu(lieu);
        residenceRepository.save(residence);
        return residence;
    }

    @Transactional
    public Residence updateResidence(Long id, String name, String pays, String region, String adresse, String gps, String lieu) {

        Residence residence = residenceRepository.findResidenceById(id);
        residence.setName(name);
        residence.setPays(pays);
        residence.setRegion(region);
        residence.setAdresse(adresse);
        residence.setGps(gps);
        residence.setType_lieu(lieu);
        residenceRepository.save(residence);
        System.out.println(residence.getAppartements());
        return residence;
    }

    public void deleteResidence(Long id) {
        Residence residence = residenceRepository.findResidenceById(id);
        List<Appartement> apps = appartementRepository.findAppartementsWithResidenceId(id);
        for (Appartement temp : apps) {
            appartementRepository.delete(temp);
        }
        residenceRepository.delete(residence);
    }

    public void addServiceToResidence(Long residence_id, Long my_service_id) {
//        Set<>

    }

}