package com.alisher.project.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User owner;

    @OneToMany(mappedBy = "chat_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Message> messages;

    @Column(nullable = false)
    private String name;
}
