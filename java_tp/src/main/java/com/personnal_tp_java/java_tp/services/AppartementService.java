package com.personnal_tp_java.java_tp.service;

import com.personnal_tp_java.java_tp.models.Appartement;
import com.personnal_tp_java.java_tp.models.Residence;
import com.personnal_tp_java.java_tp.models.Service;
import com.personnal_tp_java.java_tp.JavaTpApplication;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
public class AppartementService {
    private final AppartementRepository appartementRepository;
    private ResidenceRepository residenceRepository;


    public AppartementService(AppartementRepository appartementRepository, ResidenceRepository residenceRepository) {
        this.appartementRepository = appartementRepository;
        this.residenceRepository = residenceRepository;
    }

    public List<Appartement> getAllAppartements() {
        return appartementRepository.findAll();
    }

    @Transactional
    public Appartement createApp(String name, int surface, int nb_couchage, boolean equipement_bebe, boolean climatisation, Long residence_id) {
        Residence residence = residenceRepository.findresidenceById(residence_id);
        Appartement app = new Appartement();
        app.setName(name);
        app.setSurface(surface);
        app.setNbCouchage(nb_couchage);
        app.setEquipementBebe(equipement_bebe);
        app.setClimatisation(climatisation);
        appartementRepository.save(app);
        residence.getAppartements().add(app);
        return app;
    }

    @Transactional
    public Appartement updateApp(Long id, String name, int surface, int nb_couchage, boolean equipe_bebe,
                                 boolean climatisation, Long residence_id) {
        Residence oldResidence = residenceRepository.findResidenceIdWithAnAppId(id);
        Appartement app = appartementRepository.findAppId(id);
        oldResidence.getAppartements().remove(app);
        Residence residence = residenceRepository.findResidenceById(residence_id);
        app.setName(name);
        app.setSurface(surface);
        app.setNbCouchage(nb_couchage);
        app.setEquipementBebe(equipement_bebe);
        app.setClimatisation(climatisation);
        appartementRepository.save(app);
        residence.getAppartements().add(app);
        return app;
    }

    public void deleteApp(Long id) {
        Appartement app = appartementRepository.findAppId(id);
        appartementRepository.delete(app);
    }
}