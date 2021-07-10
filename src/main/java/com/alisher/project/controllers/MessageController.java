package com.alisher.project.controllers;

import com.alisher.project.forms.MessageSaveForm;
import com.alisher.project.models.Message;
import com.alisher.project.services.MessageService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(MessageController.ROOT_URL)
@RestController
public class MessageController {
    public static final String ROOT_URL = "/message";
    public static final String SAVE_MESSAGE_URL = "/save";

    private final MessageService messageService;

    @PostMapping(SAVE_MESSAGE_URL)
    public ResponseEntity<Message> saveMessage(@RequestBody MessageSaveForm form) {
        try {
            return new ResponseEntity<>(messageService.saveMessage(form), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Message(), HttpStatus.BAD_REQUEST);
    }
}


