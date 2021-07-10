package com.alisher.project.controllers;

import com.alisher.project.forms.ChatForm;
import com.alisher.project.models.Chat;
import com.alisher.project.services.ChatService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(ChatController.ROOT_URL)
@RestController
public class ChatController {
    public static final String ROOT_URL = "/chat";
    private static final String CREATE_CHAT_URL = "/create";
    private static final String GET_CHAT_URL = "/info/{id}";
    private static final String GET_CHAT_URL_check = "/test";

    private final ChatService chatService;

    @PostMapping(CREATE_CHAT_URL)
    public Chat createChat(@RequestBody ChatForm form) throws NotFoundException {
        return chatService.createChat(form);
    }

    @GetMapping(GET_CHAT_URL)
    public Chat getChatInfo(@PathVariable String id) {
        return chatService.getChat(Long.parseLong(id));
    }

    @GetMapping(GET_CHAT_URL_check)
    public Chat getChatInfo() {
        return chatService.getChat(Long.parseLong("1"));
    }
}
