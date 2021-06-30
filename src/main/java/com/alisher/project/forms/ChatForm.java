package com.alisher.project.forms;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatForm {
    private String name;
    private String definition;
    private Long userId;
}
