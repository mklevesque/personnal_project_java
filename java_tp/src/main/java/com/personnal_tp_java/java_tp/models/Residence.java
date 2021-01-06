package com.personnal_tp_java.java_tp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicUpdate
@Table(name = "residences"})
public class Residence {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String pays;
    private String region;
    private String adresse;
    private String gps;
    private String lieu;

    @OneToMany
    @JoinColumn(name="RESIDENCE_ID")
    private Set<Appartement> appartements;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getlieu() {
        return lieu;
    }

    public void setlieu(String lieu) {
        this.lieu = lieu;
    }

    public void setAppartements(Set<Appartement> app) {
        this.appartements = app;
    }

    public Set<Appartement> getAppartements() {
        return appartements;
    }

}