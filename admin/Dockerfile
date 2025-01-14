# Utiliser l'image openjdk avec une version de Java appropriée
FROM openjdk:17-slim

# Installer Maven manuellement
RUN apt-get update && apt-get install -y maven

# Définir le répertoire de travail
WORKDIR /app

# Copier les fichiers pom.xml (et tout autre fichier nécessaire)
COPY pom.xml .

# Télécharger les dépendances Maven (sans exécuter les tests)
RUN mvn dependency:go-offline

# Copier tous les autres fichiers sources dans le conteneur
COPY src /app/src

# Construire le projet Maven (sans tests)
RUN mvn clean install -DskipTests

# Exposer le port de l'application (si nécessaire, par exemple pour Spring Boot)
EXPOSE 8080

# Commande pour démarrer l'application
CMD ["mvn", "spring-boot:run"]
