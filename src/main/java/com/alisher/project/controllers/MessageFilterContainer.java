package com.alisher.project.controllers;

import com.alisher.project.forms.MessageFilterForm;
import com.alisher.project.services.MessageFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(MessageFilterContainer.ROOT_URL)
public class MessageFilterContainer {
    public static final String ROOT_URL = "/filter";
    public static final String CLEAN_OBSCENE_WORD_LIST_URL = "/all";
    public static   final String CLEAN_OBSCENE_WORD_URL = "/clean";

    private final MessageFilterService messageFilterService;

    @GetMapping(CLEAN_OBSCENE_WORD_URL)
    public Long cleanObsceneWords(@RequestParam String word) {
        return messageFilterService.clearObsceneMessages(word);
    }

    @GetMapping(CLEAN_OBSCENE_WORD_LIST_URL)
    public Long cleanObsceneWords(@RequestBody MessageFilterForm form) {
        return messageFilterService.clearObsceneMessages(form);
    }
}
