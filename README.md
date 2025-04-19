
# Projet DevOps – Application Spring Boot

##  Objectif
Ce projet a été réalisé dans le cadre du TP final de DevOps. Il met en pratique :
- La gestion de projet avec Git et GitHub
- La conteneurisation avec Docker
- L’orchestration avec Docker Compose
- L’intégration continue avec GitHub Actions


## Description du projet

Il s'agit d'une API REST simple développée avec Spring Boot.  
Elle expose une route `/greeting` qui retourne un message personnalisé :

**Exemple d’URL :**  
http://localhost:9092/greeting?name=ENSIM

## Initialisation du projet Git

git init
git remote add origin https://github.com/Abir-Kharmachi/Projet-DevOps.git
git add .
git commit -m "Initial commit"
git push -u origin main


### Dockerfile
L'application est conteneurisée avec une image Java 21.  
Le fichier 'Dockerfile' permet de construire l’image à partir du JAR généré.

### Docker Compose
Le fichier 'docker-compose.yml' permet de lancer l'application sur le port '9092'.
puisque dans yaml
ports:
  - "9092:9091"
  d'ou l’application écoute en interne sur le port 9091, redirigé en local sur 9092.

### Lancer le projet

docker compose pull
docker compose up -d
tester avec :
http://localhost:9092/greeting?name=ENSIM

### Problèmes rencontrés
- Erreur de version Java dans GitHub Actions : le script CI utilisait une version de Java incompatible avec le projet. Résolu en définissant la bonne version.
- Erreur de chemin dans le Dockerfile : au début, les chemins relatifs dans le `Dockerfile` ne pointaient pas correctement vers les fichiers `.jar` générés par Maven. J’ai corrigé ça en ajustant le `COPY` pour viser le bon dossier `target/`.
