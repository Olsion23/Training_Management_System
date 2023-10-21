package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.Course;
import com.sda.training_management_system.dao.Notification;
import com.sda.training_management_system.dao.User;
import com.sda.training_management_system.dao.UserNotification;
import com.sda.training_management_system.exceptions.GenericExceptions;
import com.sda.training_management_system.repositories.CourseRepository;
import com.sda.training_management_system.repositories.NotificationRepository;
import com.sda.training_management_system.repositories.UserNotificationRepository;
import com.sda.training_management_system.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final CourseRepository courseRepository;
    private UserNotificationRepository userNotificationRepository;
    private final NotificationRepository notificationRepository;
    @Override
    public Notification create(Notification entity) {
        return null;
    }

    @Override
    public Notification update(Notification entity) {
        return null;
    }

    @Override
    public Notification findById(Long notificationId) {
        return null;
    }

    @Override
    public List<Notification> findAll() {
        return null;
    }

    @Override
    public String delete(Long notificationId) {
        return null;
    }

    @Override
    public void createNotificationForCourse(Long courseId, Notification notification) {
        AtomicReference<Notification> newNotification =
                new AtomicReference<>(notificationRepository.save(notification));
        Course course = courseRepository.findById(courseId).orElseThrow(()-> GenericExceptions.notFound(courseId));
        List<User> participants = course.getParticipants();
        participants.forEach(participant -> {
            UserNotification userNotification = new UserNotification();
            userNotification.setNotification(newNotification.get());
            userNotification.setUser(participant);
            userNotification.setReaded(false);
            userNotificationRepository.save(userNotification);
        });
    }
}
