package com.sda.patientportal.controller;

import com.sda.patientportal.model.Messages;
import com.sda.patientportal.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/messages")
public class MessagesController {

    private MessagesService messagesService;

    @Autowired
    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    public MessagesService getMessagesService() {
        return messagesService;
    }

    public void setMessagesService(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @PostMapping
    public Messages createDoctor(@RequestBody Messages messages) {
        messages.setId(null);
        return messagesService.createMessage(messages);
    }

}
