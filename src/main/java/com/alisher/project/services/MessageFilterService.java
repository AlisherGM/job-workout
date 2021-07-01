package com.alisher.project.services;

import com.alisher.project.forms.MessageFilterForm;
import com.alisher.project.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class MessageFilterService {
        private final MessageRepository messageRepository;

        public Long clearObsceneMessages(String obsceneWord) {
                int i = 1;
                return messageRepository.deleteBySrcIgnoreCaseContains(obsceneWord);
        }

        public Long clearObsceneMessages(MessageFilterForm form) {
                return messageRepository.deleteBySrcIgnoreCaseContains(form.getObsceneWords());
        }
}

