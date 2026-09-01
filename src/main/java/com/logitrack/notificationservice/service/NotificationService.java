package com.logitrack.notificationservice.service;

import com.logitrack.notificationservice.entity.Notification;

import java.util.List;

public interface NotificationService {

    List<Notification> getAllNotifications();

    Notification getNotificationById(Long id);

    List<Notification> getNotificationsByOrderId(Long orderId);

    Notification createNotification(Notification notification);

    Notification markAsRead(Long id);
}