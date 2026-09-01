CREATE TABLE notifications (
                               id BIGSERIAL PRIMARY KEY,
                               message VARCHAR(255) NOT NULL,
                               kind VARCHAR(50) NOT NULL,
                               date_creation TIMESTAMP NOT NULL,
                               read BOOLEAN NOT NULL DEFAULT FALSE,
                               order_id BIGINT NOT NULL
);