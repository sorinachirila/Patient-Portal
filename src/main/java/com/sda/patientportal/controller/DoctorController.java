package com.sda.patientportal.controller;

import com.sda.patientportal.model.Doctor;
import com.sda.patientportal.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public DoctorService getDoctorService() {
        return doctorService;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor d) {
        d.setId(null);
        return doctorService.createDoctor(d);
    }

    @GetMapping(value = "/{id}")
    public Doctor get(@PathVariable Long id) {
        return doctorService.get(id);
    }

 /*   @GetMapping
    public List<Doctor> getAll() {
        return doctorService.getAllDoctors();
    }*/

    @GetMapping
    public List<Doctor> getAllDoctors(@RequestParam(name = "lastName", required = false) String lastName) {
        if (lastName != null) {
            return doctorService.getAllDoctorsByLastName(lastName);
        } else {
            return doctorService.getAllDoctors();
        }
    }

    @PutMapping(value = "/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        if (id != doctor.getId()) {
            throw new RuntimeException("Ids not match!");
        }

        if (doctorService.get(doctor.getId()) == null) {
            throw new RuntimeException("Doctor does not exist");
        }
        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
}
