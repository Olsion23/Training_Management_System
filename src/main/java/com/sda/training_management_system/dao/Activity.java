package com.sda.training_management_system.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Activities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue
    private Long activityId;
    private String subject;
    private Date date;
    @ManyToOne
    private Class aClass;
}
