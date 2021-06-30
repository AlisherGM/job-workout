package com.alisher.project.services;

import com.alisher.project.forms.MessageFilterForm;
import com.alisher.project.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageFilterService {
        private final MessageRepository messageRepository;

        public Long clearObsceneMessages(String obsceneWord) {
                return messageRepository.deleteBySrcIgnoreCaseContains(obsceneWord);
        }

        public Long clearObsceneMessages(MessageFilterForm form) {
                return messageRepository.deleteBySrcIgnoreCaseContains(form.getObsceneWords());
        }
}

