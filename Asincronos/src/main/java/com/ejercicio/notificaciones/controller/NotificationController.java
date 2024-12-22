
package com.ejercicio.notificaciones.controller;

import com.ejercicio.notificaciones.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<String> createNotification(@RequestBody String message) {
        notificationService.sendNotification(message);
        return ResponseEntity.ok("Notification sent!");
    }

    @GetMapping
    public ResponseEntity<?> getNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }
}
