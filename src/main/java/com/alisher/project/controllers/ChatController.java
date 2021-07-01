package com.alisher.project.controllers;

import com.alisher.project.forms.ChatForm;
import com.alisher.project.models.Chat;
import com.alisher.project.services.ChatService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(ChatController.ROOT_URL)
@RestController
public class ChatController {
    public static final String ROOT_URL = "/chat";
    private static final String CREATE_CHAT_URL = ROOT_URL + "/create";

    private final ChatService chatService;

    @PostMapping(CREATE_CHAT_URL)
    public Chat createChat(@ModelAttribute ChatForm form) throws NotFoundException {
        return chatService.createChat(form);
    }
}
