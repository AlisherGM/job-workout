package com.alisher.project.controllers;

import com.alisher.project.forms.MessageFilterForm;
import com.alisher.project.services.MessageFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(MessageController.ROOT_URL)
public class MessageFilterContainer {
    public final String ROOT_URL = "/filter";
    public final String CLEAN_OBSCENE_WORD_LIST_URL = ROOT_URL + "/all";
    public final String CLEAN_OBSCENE_WORD_URL = ROOT_URL + "/{word}";

    private final MessageFilterService messageFilterService;

    @GetMapping(CLEAN_OBSCENE_WORD_URL)
    public Long cleanObsceneWords(@PathVariable String word) {
        return messageFilterService.clearObsceneMessages(word);
    }

    @GetMapping(CLEAN_OBSCENE_WORD_LIST_URL)
    public Long cleanObsceneWords(@ModelAttribute MessageFilterForm form) {
        return messageFilterService.clearObsceneMessages(form);
    }
}
