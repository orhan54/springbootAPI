FROM eclipse-temurin:21-jre

# Exposer le port 8080
EXPOSE 8080

# Repertoire de travail dans le conteneur pour stocker le jar
WORKDIR /app

# Copie du fichier JAR recuperer de l'artefact de votre projet le jar
COPY /target/*.jar app.jar

# Point d'entree pour executer le fichier JAR
ENTRYPOINT ["java","-jar","app.jar"]
