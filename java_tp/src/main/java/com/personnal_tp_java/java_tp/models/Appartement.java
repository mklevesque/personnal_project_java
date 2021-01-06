package com.personnal_tp_java.java_tp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "appartements")

public class Appartement {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToMany
    @JoinColumn(name="APPARTEMENT_ID")

    @column(name ="name")
    private String name;
    @column(name ="nb_couchage")
    private int nb_couchage;
    @column(name ="surface")
    private int surface;
    @column(name ="equipement_bebe")
    private boolean equipement_bebe;
    @column(name ="climatisation")
    private boolean climatisation;

    public boolean getEquipementBebe() {return equipement_bebe;}

    public boolean getClimatisation() {return climatisation;}

    public void setEquipementBebe(boolean equipement_bebe) {this.equipement_bebe = equipement_bebe;}

    public void setClimatisation(boolean climatisation) {this.climatisation = climatisation;}

    public Long getId() {return id;}

    public void setName(String name) {this.name = name;}

    public String getName() {return name;}

    public int getNbCouchage() {return nb_couchage;}

    public void setNbCouchage(int nb_couchage) {this.nb_couchage = nb_couchage;}

    public int getSurface() {return surface;}

    public void setSurface(int surface) {this.surface = surface;}

}