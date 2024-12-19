package com.example.Voiture.services;

import com.example.Voiture.entities.Voiture;
import com.example.Voiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;

    // Save a voiture to the database
    @Transactional
    public Voiture saveVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    // Find all voitures
    public List<Voiture> findAllVoitures() {
        return voitureRepository.findAll();
    }

    // Find a voiture by its ID
    public Voiture findById(Long id) {
        return voitureRepository.findById(id).orElse(null);
    }

    // Find voitures by client ID
    public List<Voiture> findByClientId(Long clientId) {
        return voitureRepository.findByClientId(clientId);
    }

    // Update a voiture's details
    @Transactional
    public Voiture updateVoiture(Long id, Voiture updatedVoiture) {
        Voiture existingVoiture = voitureRepository.findById(id).orElseThrow(() -> new RuntimeException("Voiture not found with ID: " + id));
        existingVoiture.setMatricule(updatedVoiture.getMatricule());
        existingVoiture.setMarque(updatedVoiture.getMarque());
        existingVoiture.setModel(updatedVoiture.getModel());
        return voitureRepository.save(existingVoiture);
    }
}
