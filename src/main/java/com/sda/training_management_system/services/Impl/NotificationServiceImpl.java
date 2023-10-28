package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.Class;
import com.sda.training_management_system.dao.Course;
import com.sda.training_management_system.dao.Notification;
import com.sda.training_management_system.dao.User;
import com.sda.training_management_system.dao.UserNotification;
import com.sda.training_management_system.exceptions.GenericExceptions;
import com.sda.training_management_system.repositories.CourseRepository;
import com.sda.training_management_system.repositories.NotificationRepository;
import com.sda.training_management_system.repositories.UserNotificationRepository;
import com.sda.training_management_system.services.ClassService;
import com.sda.training_management_system.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final ClassService classService;
    private final UserNotificationRepository userNotificationRepository;
    private final NotificationRepository notificationRepository;
    @Override
    public Notification create(Notification entity) {
        return null;
    }

    @Override
    public Notification update(Notification entity) {
        if (entity.getNotificationId() == null) {
            throw GenericExceptions.idIsNull();
        } else {
            Notification existingNotification = this.findById(entity.getNotificationId());
            if (entity.getSubject() != null)
                existingNotification.setSubject(entity.getSubject());
            if (entity.getContent() != null)
                existingNotification.setContent(entity.getContent());
            notificationRepository.save(existingNotification);
            return existingNotification;
        }
    }

    @Override
    public Notification findById(Long notificationId) {
        Optional<Notification> user = notificationRepository.findById(notificationId);
        return user.orElseThrow(()-> GenericExceptions.notFound(notificationId));
    }

    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public String delete(Long notificationId) {
        notificationRepository.findById(notificationId);
        return String.format("Record with id %d deleted", notificationId);
    }

    @Override
    public void createNotificationForCourse(Long classId, Notification notification) {
        AtomicReference<Notification> newNotification =
                new AtomicReference<>(notificationRepository.save(notification));
        Class clazz = classService.findById(classId);
        List<User> participants = clazz.getParticipants();
        participants.forEach(participant -> {
            UserNotification userNotification = new UserNotification();
            userNotification.setNotification(newNotification.get());
            userNotification.setUser(participant);
            userNotification.setReaded(false);
            userNotificationRepository.save(userNotification);
        });
    }
}
