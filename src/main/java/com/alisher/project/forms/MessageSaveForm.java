package com.alisher.project.forms;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageSaveForm {
    private String message;
    private Long userId;
    private Long chatId;
}
