# Etapa 1: Construcción
FROM maven:3.8.4-openjdk-17-slim AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar los archivos necesarios
COPY pom.xml .
COPY src ./src

# Compilar el proyecto con Maven
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución
FROM eclipse-temurin:17-jdk-alpine

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el JAR generado desde la etapa anterior
COPY --from=build /app/target/consumerEvaluacion-0.0.1-SNAPSHOT.jar .

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "consumerEvaluacion-0.0.1-SNAPSHOT.jar"]