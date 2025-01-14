# Étape 1 : Image de base pour Maven pour construire le projet
FROM maven:3.8.5-openjdk-11 AS builder

# Définir le répertoire de travail
WORKDIR /app

# Copier uniquement les fichiers nécessaires pour le build Maven (optimisation du cache)
COPY pom.xml ./
COPY src ./src

# Construire le projet en sautant les tests
RUN mvn clean package -DskipTests

# Étape 2 : Image pour exécuter l'application Spring Boot
FROM openjdk:11-jre-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier jar généré depuis le builder
COPY --from=builder /app/target/*.jar app.jar

# Exposer le port sur lequel l'application fonctionne
EXPOSE 8019

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
