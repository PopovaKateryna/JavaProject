# Використовуємо офіційний образ Java
FROM openjdk:18-jdk-slim

# Встановлюємо робочу директорію для нашого додатку
WORKDIR /usr/app

# Копіюємо зібраний jar-файл у нашу робочу директорію
COPY target/study-spring-2022-1.0-SNAPSHOT.jar /usr/app/app.jar

# Відкриваємо порт 8080
EXPOSE 8080
# Запускаємо наш додаток
CMD ["java", "-jar", "app.jar"]

