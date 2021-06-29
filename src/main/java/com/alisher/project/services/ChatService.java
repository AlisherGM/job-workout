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
        User user = userRepository.findById(chatForm.getUserId())
                .orElseThrow(()->new NotFoundException("User with id = " + chatForm.getUserId() + " not founded"));
        Chat chat = Chat.builder()
                .user(user)
                .name(chatForm.getName())
                .definition(chatForm.getDefinition())
                .build();
        return chatRepository.save(chat);
    }
}
