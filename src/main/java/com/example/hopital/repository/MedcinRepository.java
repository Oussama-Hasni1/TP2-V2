package com.example.hopital.repository;

import com.example.hopital.entities.Medcin;
import com.example.hopital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcinRepository extends JpaRepository<Medcin, Long> {
    Medcin findByNom(String nom);

}
