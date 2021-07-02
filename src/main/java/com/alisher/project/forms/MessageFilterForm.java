package com.alisher.project.forms;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageFilterForm {
    private List<String> obsceneWords;
}
