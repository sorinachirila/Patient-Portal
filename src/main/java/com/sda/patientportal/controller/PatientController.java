package com.sda.patientportal.controller;

import com.sda.patientportal.model.Patient;
import com.sda.patientportal.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping(value = "/patients")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

   /* @GetMapping(value = "/demo")
    public String demo() {
        return "Hello demo http get";
    }*/

   /* @PostMapping(value = "/demo", consumes = "application/json", produces = "application/text")
    public String demo2(@RequestBody String message) {
        return "Hello demo http post  " + message;
    }*/

    @PostMapping
    public Patient createPatient(@RequestBody Patient p) {
        p.setId(null);
        return patientService.createPatient(p);
    }

    @GetMapping(value = "/{id}")
    public Patient get(@PathVariable Long id) {
        return patientService.get(id);
    }

    @GetMapping
    public List<Patient> getAllPatients(@RequestParam(name = "lastName", required = false) String lastName) {
        if (lastName != null) {
            return patientService.getAllPatientsByLastName(lastName);
        } else {
            return patientService.getAllPatients();
        }
    }

    @PutMapping(value = "/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        if (id != patient.getId()) {
            throw new RuntimeException("Ids is not match");
        }
        if (patientService.get(patient.getId()) == null) {
            throw new RuntimeException("Patient does not exist");
        }
        return patientService.updatePatient(patient);
    }

    @DeleteMapping(value = "/{id}")
   // @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
