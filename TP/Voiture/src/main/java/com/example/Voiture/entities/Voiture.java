package com.example.Voiture.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marque;
    private String matricule;
    private String model;

    private Long id_client;


    @Transient
    @ManyToOne
    private Client client;

    public Long getClientId() {
        return  id_client;
    }

    public void setClientId(Long id_client) {
        this.id_client = id_client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Voiture() {
    }

    public Voiture(Long id, String marque, String matricule, String model, Long id_client, Client client) {
        this.id = id;
        this.marque = marque;
        this.matricule = matricule;
        this.model = model;
        this.id_client = id_client;
        this.client = client;
    }
}
