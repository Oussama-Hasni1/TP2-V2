package com.example.hopital;

import com.example.hopital.entities.*;
import com.example.hopital.repository.ConsultationRepository;
import com.example.hopital.repository.MedcinRepository;
import com.example.hopital.repository.PatientRepository;
import com.example.hopital.repository.RendezVousRepository;
import com.example.hopital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HopitalApplication  {



    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }
    @Bean
    CommandLineRunner star(HospitalService hospitalService, PatientRepository patientRepository, MedcinRepository medcinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository){
        return  args -> {
            Stream.of("Mohamed","Hassan","Najat")
                    .forEach(name->{
                        Patient patient = new Patient();
                        patient.setName(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        patientRepository.save(patient);
                    });
            Stream.of("Aymane","Hanane","Yasmine")
                    .forEach(name->{
                        Medcin medcin = new Medcin();
                        medcin.setNom(name);
                        medcin.setEmail(name+"@gmail.com");
                        medcin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        medcinRepository.save(medcin);
                    });
            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByName("Mohamed");
            Medcin medcin=medcinRepository.findByNom("Yasmine");
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedcin(medcin);
            hospitalService.saveRDV(rendezVous);


            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("rapport de la consultation .....");
            consultationRepository.save(consultation);



        };
    }
}
