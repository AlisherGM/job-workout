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
@Table(name = "customer_phones")
public class CustomerPhone {
    public CustomerPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "phones")
    private String phone;

    @Column(name = "creation_time", unique = true)
    private LocalDateTime creationTime;
}
