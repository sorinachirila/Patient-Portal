package com.sda.patientportal.repository;

import com.sda.patientportal.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findById(Long id);

    List<Patient> findAll();

    Patient findByFirstName(String firstName);

    Patient findByFirstNameAndLastName(String firstName, String lastName);

    List<Patient> findAllByLastName(String lastName);

    void deleteById(Long id);


}
