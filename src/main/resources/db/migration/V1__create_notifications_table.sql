CREATE TABLE notifications (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               message VARCHAR(255) NOT NULL,
                               kind VARCHAR(50) NOT NULL,
                               date_creation DATETIME NOT NULL,
                               is_read BOOLEAN NOT NULL DEFAULT FALSE,
                               order_id BIGINT NOT NULL
);