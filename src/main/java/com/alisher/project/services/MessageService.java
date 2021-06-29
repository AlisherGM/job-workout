package com.alisher.project.services;

import com.alisher.project.forms.MessageSaveForm;
import com.alisher.project.models.Chat;
import com.alisher.project.models.Message;
import com.alisher.project.models.User;
import com.alisher.project.repositories.ChatRepository;
import com.alisher.project.repositories.MessageRepository;
import com.alisher.project.repositories.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;

    public Message saveMessage(MessageSaveForm form) throws NotFoundException {
        User user = userRepository.findById(form.getUserId())
                .orElseThrow(()-> new NotFoundException("User with such id = " + form.getUserId() + " not founded"));
        Chat chat = chatRepository.findById(form.getChatId())
                .orElseThrow(()-> new NotFoundException("Chat with suck id = " + form.getChatId() + " not founded"));
        return messageRepository.save(Message.builder()
                .src(form.getMessage())
                .user(user)
                .chat(chat)
                .build());
    }
}
