package com.logitrack.notificationservice.service;

import com.logitrack.notificationservice.dto.NotificationRequest;
import com.logitrack.notificationservice.dto.NotificationResponse;
import com.logitrack.notificationservice.entity.Notification;
import com.logitrack.notificationservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public List<NotificationResponse> getAllNotifications() {
        return notificationRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public NotificationResponse getNotificationById(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Notification not found with id: " + id)
                );

        return toResponse(notification);
    }

    @Override
    public List<NotificationResponse> getNotificationsByOrderId(Long orderId) {
        return notificationRepository.findByOrderId(orderId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public NotificationResponse createNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                .message(request.message())
                .kind(request.kind())
                .dateCreation(LocalDateTime.now())
                .read(false)
                .orderId(request.orderId())
                .build();

        Notification savedNotification =
                notificationRepository.save(notification);

        return toResponse(savedNotification);
    }

    @Override
    public NotificationResponse markAsRead(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Notification not found with id: " + id)
                );

        notification.setRead(true);

        Notification savedNotification =
                notificationRepository.save(notification);

        return toResponse(savedNotification);
    }

    private NotificationResponse toResponse(Notification notification) {
        return new NotificationResponse(
                notification.getId(),
                notification.getMessage(),
                notification.getKind(),
                notification.getDateCreation(),
                notification.isRead(),
                notification.getOrderId()
        );
    }
}