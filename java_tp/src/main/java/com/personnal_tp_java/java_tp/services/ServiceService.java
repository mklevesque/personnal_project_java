package com.personnal_tp_java.java_tp.service;

import com.personnal_tp_java.java_tp.models.Appartement;
import com.personnal_tp_java.java_tp.models.Residence;
import com.personnal_tp_java.java_tp.models.Service;
import com.personnal_tp_java.java_tp.JavaTpApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;
    private final ResidenceRepository residenceRepository;

    public ServiceService(ServiceRepository serviceRepository, ResidenceRepository residenceRepository) {
        this.serviceRepository = serviceRepository;
        this.residenceRepository = residenceRepository;
    }

    @Transactional
    public List<Service> getServices() {
        return serviceRepository.getAllServices();
    }

    @Transactional
    public Service createService(String detail_service, Long residence_id) {
        Residence residence = residenceRepository.findResidenceById(residence_id);
        Service service = new Service();
        service.setDetailService(detail_service);
        serviceRepository.save(service);
        residence.getServices().add(service);
        return service;
    }

    @Transactional
    public Service updateService(Long id, String detail_service, Long residence_id) {
        Residence oldResidence = residenceRepository.findResidenceById(residence_id);
        Service service = serviceRepository.findServiceById(id);
        oldResidence.getAppartements().remove(service);
        Residence residence = residenceRepository.findResidenceById(residence_id);
        service.setDetailService(detail_service);
        serviceRepository.save(service);
        residence.getervices().add(service);
        return service;
    }

    public void deleteService(Long id) {
        Service service = serviceRepository.findServiceById(id);
        serviceRepository.delete(service);
    }
}