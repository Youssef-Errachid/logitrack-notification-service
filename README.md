# LogiTrack Notification Service

An independent Spring Boot microservice responsible for managing 
order notifications in the LogiTrack ecosystem.

## Overview

This service communicates with the LogiTrack API using OpenFeign. 
When an order is created, shipped, or delivered, LogiTrack triggers 
an HTTP call to this service which creates and stores the notification 
in its own database.

## Features

- Receive and store order notifications
- Mark notifications as read
- Filter notifications by order
- Independent database and configuration
- Error handling for inter-service communication

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web
- OpenFeign
- MySQL
- Flyway
- Docker

## Endpoints


| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/notifications | Get all notifications |
| GET | /api/notifications/{id} | Get notification by id |
| GET | /api/notifications/order/{orderId} | Get notifications by order |
| POST | /api/notifications | Create a notification |
| PUT | /api/notifications/{id}/read | Mark as read |

## Run with Docker

```bash
docker-compose up -d
```

## Part of LogiTrack Project

- Part 1 — REST API (Spring Boot + JPA)
- Part 2 — Security (Spring Security + JWT)
- Part 3 — Monitoring (Prometheus + Grafana + Loki)
- Part 4 — Notification Microservice ← You are here
