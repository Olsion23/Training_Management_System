package com.sda.training_management_system.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    private String login;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
    private String firstName;
    private String lastName;
    private Boolean active;
    @OneToMany(mappedBy = "participant")
    private List<Application> applications;

    @ManyToMany(mappedBy = "participants")
    private List<Class> participantClasses;

    @ManyToMany(mappedBy = "leaders")
    private List<Class> leaderClasses;

    @OneToMany(mappedBy = "user")
    private List<UserNotification> notifications;

}
