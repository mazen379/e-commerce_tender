# Étape 1 : Utilisation d'une image Maven pour construire le projet
FROM maven:3.8.4-openjdk-17 AS build

# Étape 2 : Image pour exécuter l'application Spring Boot
FROM openjdk:17-jdk



# Répertoire de travail dans le conteneur
WORKDIR /app

COPY target/*.jar /app/admin.jar

# Exposer le port sur lequel l'application Spring Boot écoute
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["sh", "-c", "sleep 30 && java -jar admin.jar"]

