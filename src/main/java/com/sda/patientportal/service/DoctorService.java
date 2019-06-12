package com.sda.patientportal.service;

import com.sda.patientportal.model.Doctor;
import com.sda.patientportal.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    //create
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }


    //getById
    public Doctor get(Long id) {
      /*  Doctor d = new Doctor();
        d.setFirstName("Popa");
        d.setLastName("She");
        d.setId(id);
        d.setHospital("Hospital");
        System.out.println(d.getFirstName());
        return d;*/
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.orElse(null);
    }

    //getAll
    public List<Doctor> getAllDoctors() {
       /* String firstName = "Popescu";
        String lastName = "He";
        List<Doctor> listDoctors = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Doctor doctor = new Doctor(firstName + i, lastName + i);

            listDoctors.add(doctor);
        }
        return listDoctors;*/
        return doctorRepository.findAll();
    }

    //getAllByLastName
    public List<Doctor> getAllDoctorsByLastName(String lastName) {
        return doctorRepository.findAllByLastName(lastName);
    }

    public Doctor updateDoctor(Doctor doctor) {
     /*   d.setFirstName("FirstNameTest");
        d.setLastName("LastNameTest");
        System.out.println("Doctor updated!");
        return d;*/
        return doctorRepository.save(doctor);
    }

    //deleteById
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
