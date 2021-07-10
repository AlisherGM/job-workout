package com.alisher.project.models;

import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer",
        uniqueConstraints = {
                @UniqueConstraint(name = "customer_id_and_tenant_id_uniq", columnNames = {"customer_id", "tenant_id"})
       })
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "tenant_id")
    private String tenantId;

    private String firstName;

    private String middleName;

    private String lastName;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "customer_phones", joinColumns = @JoinColumn(name = "customer_id")) // customer_id refers to id (Long) not to customerId (String)
//    private Set<String> phones = new HashSet<>();
//
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "customer_emails", joinColumns = @JoinColumn(name = "customer_id"))
//    private Set<String> emails = new HashSet<>();


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "customer_phones", joinColumns = @JoinColumn(name = "customer_id"))
    @OrderBy("creationTime desc ")
    private List<CustomerPhone> phones = new ArrayList<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "customer_emails", joinColumns = @JoinColumn(name = "customer_id"))
    @OrderBy("creationTime desc")
    private List<CustomerEmail> emails = new ArrayList<>();

    private String type;
}
