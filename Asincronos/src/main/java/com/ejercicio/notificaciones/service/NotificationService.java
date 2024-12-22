
package com.ejercicio.notificaciones.service;

import com.ejercicio.notificaciones.entity.Notification;
import com.ejercicio.notificaciones.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationProducer notificationProducer;

    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(String message) {
        notificationProducer.sendNotification(message);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
