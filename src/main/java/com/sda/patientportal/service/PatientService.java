package com.sda.patientportal.service;

import com.sda.patientportal.model.Patient;
import com.sda.patientportal.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository pR;

    //create
    public Patient createPatient(Patient patient) {
        return pR.save(patient);
    }

    //get
    public Patient get(Long id) {
    /*    Patient p = new Patient();
        p.setFirstName("Popa");
        p.setLastName("She");
        p.setId(id);
        System.out.println(p.getFirstName());
        return p;*/

        Optional<Patient> patient = pR.findById(id);
        return patient.orElse(null);
    }

    //getAll
    public List<Patient> getAllPatients() {
      /*  String firstName = "Popescu";
        String lastName = "He";
        List<Patient> listPatient = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Patient patient = new Patient(firstName + i, lastName + i);
            listPatient.add(patient);
        }
        return listPatient;*/

        return pR.findAll();
    }

    //getAllByLastName
    public List<Patient> getAllPatientsByLastName(String lastName) {
        return pR.findAllByLastName(lastName);
    }

    //update
    public Patient updatePatient(Patient p) {
        //Patient patient = new Patient();
        // p.setId(id);
        // p.getId();
        //p.setFirstName("FirstNameTest11");
        //p.setLastName("LastNameTest111");
/*
        if (id != p.getId()) {
            return null;
        }*/
  /*      p.setFirstName(p.getFirstName());
        p.setLastName(p.getFirstName());*/

        return pR.save(p);
    }


    //delete
    public void deletePatient(Long id) {
        //Patient patient = new Patient(id, "firstName", "lastName");
       /* if (id != patient.getId()) {
        }*/
      /*  patient.setId(0L);
        patient.setFirstName(null);
        patient.setLastName(null)*/

       pR.deleteById(id);

    }
}
