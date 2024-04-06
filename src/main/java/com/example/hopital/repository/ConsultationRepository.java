package com.example.hopital.repository;

import com.example.hopital.entities.Consultation;
import com.example.hopital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
