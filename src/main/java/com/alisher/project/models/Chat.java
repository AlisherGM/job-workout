package com.alisher.project.models;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String definition;
}
