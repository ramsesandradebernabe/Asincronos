
package com.ejercicio.notificaciones.service;

import com.ejercicio.notificaciones.entity.Notification;
import com.ejercicio.notificaciones.repository.NotificationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationConsumer {

    @Autowired
    private NotificationRepository notificationRepository;

    @RabbitListener(queues = "notificationQueue")
    public void receiveNotification(String message) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setStatus("PROCESSED");
        notification.setCreatedAt(LocalDateTime.now());
        notificationRepository.save(notification);
    }
}
