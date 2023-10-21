package com.sda.training_management_system.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Classes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue
    private Long classId;
    private String subject;
    @ManyToOne
    private Course course;
    @OneToMany(mappedBy = "aClass")
    List<Activity> activities;
}
