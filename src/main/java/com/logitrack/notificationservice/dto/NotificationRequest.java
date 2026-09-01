package com.logitrack.notificationservice.dto;

import com.logitrack.notificationservice.entity.NotificationKind;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NotificationRequest(

        @NotBlank(message = "Message is required")
        String message,

        @NotNull(message = "Notification kind is required")
        NotificationKind kind,

        @NotNull(message = "Order ID is required")
        Long orderId

) {
}