package com.example.hopital.service;

import com.example.hopital.entities.Consultation;
import com.example.hopital.entities.Medcin;
import com.example.hopital.entities.Patient;
import com.example.hopital.entities.RendezVous;

public interface HospitalService {
     Patient savePatient(Patient patient);
     Medcin saveMedcin(Medcin medcin);
     RendezVous saveRDV(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);
}
