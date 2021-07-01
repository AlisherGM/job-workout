package com.alisher.project.models;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name="messages")
public class Message{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="chat_id", nullable = false)
    private Chat chat;

    @Column(nullable = false)
    private String src;
}
