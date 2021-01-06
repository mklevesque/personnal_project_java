package com.personnal_tp_java.java_tp.controllers;

import com.personnal_tp_java.java_tp.model.Service;
import com.personnal_tp_java.java_tp.service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class ServiceController {
    ServiceService ServiceService;

    public ServiceController(ServiceService ServiceService) {
        this.serviceService = ServiceService;
    }

    @GetMapping("/services")
    @ResponseStatus(HttpStatus.OK)
    public List<Service> getServices() {
        return serviceService.getServices();
    }

    @PostMapping("/service/create/{detail_service}/{residence_id}")
    @ResponseStatus(HttpStatus.OK)
    public Service createService(@PathVariable String detail_service, @PathVariable Long residence_id) {
        return serviceService.createService(detail_service, residence_id);
    }

    @PutMapping("/service/update/{id}/{detail_service}/{residence_id}")
    @ResponseStatus(HttpStatus.OK)
    public Service updateService(@PathVariable Long id, @PathVariable String detail_service, @PathVariable Long residence_id){
        return serviceService.updateService(id, detail_service, residence_id);
    }

    @DeleteMapping("/service/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
    }

}