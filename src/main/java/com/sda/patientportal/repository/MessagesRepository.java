package com.sda.patientportal.repository;

import com.sda.patientportal.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {

/*    Optional<Messages> findById(Long id);

    List<Messages> findAll();*/

    /*  List<Messages> findAllByLastName(String lastName);*/

    /*  void deleteById(Long id);*/
}
