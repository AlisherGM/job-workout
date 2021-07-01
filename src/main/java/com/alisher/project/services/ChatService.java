package com.alisher.project.services;

import com.alisher.project.forms.ChatForm;
import com.alisher.project.models.Chat;
import com.alisher.project.models.User;
import com.alisher.project.repositories.ChatRepository;
import com.alisher.project.repositories.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public Chat createChat(ChatForm chatForm) throws NotFoundException {
        User owner = userRepository.findById(chatForm.getOwnerId())
                .orElseThrow(()->new NotFoundException("User with id = " + chatForm.getOwnerId() + " not founded"));
        Chat chat = Chat.builder()
                .owner(owner)
                .name(chatForm.getName())
                .build();
        return chatRepository.save(chat);
    }
}
