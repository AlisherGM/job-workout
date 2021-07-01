package com.alisher.project.forms;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatForm {
    private String name;
    private String definition;
    private Long ownerId;
}
