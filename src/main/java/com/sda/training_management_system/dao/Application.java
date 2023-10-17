package com.sda.training_management_system.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue
    private Long applicationId;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "participantId")
    private User participant;
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;



}
