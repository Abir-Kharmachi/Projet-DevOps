# Utilisez l'image officielle OpenJDK pour la base
FROM openjdk:11-jre-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier jar dans le répertoire de travail
COPY TP3-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port que votre application utilise
EXPOSE 8080

# Définir la commande pour exécuter l'application
CMD ["java", "-jar", "app.jar"]
