package com.sda.patientportal.service;

import com.sda.patientportal.model.Messages;
import com.sda.patientportal.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagesService {

    @Autowired
    private MessagesRepository messagesRepository;

    //create
    public Messages createMessage(Messages message) {
        return messagesRepository.save(message);
    }
}
