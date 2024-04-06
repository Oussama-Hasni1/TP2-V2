package com.example.hopital.repository;

import com.example.hopital.entities.Patient;
import com.example.hopital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {

}
