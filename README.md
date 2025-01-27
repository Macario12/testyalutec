# Evaluación Yalutec

Este proyecto es una solución basada en microservicios que incluye servicios para la gestión de productos, un backend for frontend (BFF) y un consumidor de eventos Kafka, utilizando tecnologías como Docker, NestJS, Kafka y MongoDB.

---

## 🛠️ Tecnologías

- **Node.js**
- **MongoDB**
- **Kafka**
- **Docker**
- **Swagger**

---

## 🚀 Configuración del Proyecto

### Requisitos Previos
- **Docker** y **Docker Compose** instalados.
- Puertos en libres:
  - `3000` (CRUD Productos)
  - `4000` (BFF)
  - `8080` (Consumidor de Eventos)
  - `9092` (Kafka)
  - `27017` (MongoDB)

---

## ⚙️ Pasos para Ejecutar el Proyecto

1. **Clonar el Repositorio**
   ```bash
   git clone https://github.com/Macario12/testyalutec.git
   cd evaluacionyalutec

2. **Ejecutar Docker Compose**
**Clonar el Repositorio**
   ```bash
   docker-compose up -d --build

## ⚙️ Documentación Swagger

  - `http://localhost:8080/swagger-ui.html` (Consumidor de Eventos)
  - `http://localhost:3000/swagger-ui.html` (CRUD Productos)
  - `http://localhost:4000/api-docs#/` (BFF)