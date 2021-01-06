package com.personnal_tp_java.java_tp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String detailService;

    public Long getId() {
        return id;
    }

    public String getDetailService() {
        return detailService;
    }

    public void setDetailService(String detailService) {
        this.detailService = detailService;
    }

}