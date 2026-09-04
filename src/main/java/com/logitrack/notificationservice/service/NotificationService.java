package com.logitrack.notificationservice.service;

import com.logitrack.notificationservice.dto.NotificationRequest;
import com.logitrack.notificationservice.dto.NotificationResponse;

import java.util.List;

public interface NotificationService {

    List<NotificationResponse> getAllNotifications();

    NotificationResponse getNotificationById(Long id);

    List<NotificationResponse> getNotificationsByOrderId(Long orderId);

    NotificationResponse createNotification(NotificationRequest request);

    NotificationResponse markAsRead(Long id);
}