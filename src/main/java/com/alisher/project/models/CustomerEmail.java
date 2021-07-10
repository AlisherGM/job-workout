package com.alisher.project.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Table(name = "customer_emails")
public class CustomerEmail {
    public CustomerEmail(String email) {
        this.email = email;
    }

    @Column(name = "emails", unique = true)
    private String email;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;
}
