package com.logitrack.notificationservice.dto;

import com.logitrack.notificationservice.entity.NotificationKind;

import java.time.LocalDateTime;

public record NotificationResponse(

        Long id,

        String message,

        NotificationKind kind,

        LocalDateTime dateCreation,

        boolean read,

        Long orderId

) {
}