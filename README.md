
# Projet DevOps – Application Spring Boot

##  Objectif
Ce projet a été réalisé dans le cadre du TP final de DevOps. Il met en pratique :
- La gestion de projet avec Git et GitHub
- La conteneurisation avec Docker
- L’orchestration avec Docker Compose
- L’intégration continue avec GitHub Actions
- Création automatique de tags Git



## Description du projet

Ce projet est une application Java Spring Boot qui propose une interface web permettant de :

- Consulter des **adresses enregistrées**
- Ajouter une **nouvelle adresse**
- Obtenir un message d'accueil
- Tester une **météo simulée** à une adresse

L’application est conteneurisée avec Docker, lancée avec Docker Compose, et automatisée avec GitHub Actions.


**Exemple d’URL :**  
- Accueil : `http://localhost:9092/greeting`
- Liste des adresses : `http://localhost:9092/adresses`
- Formulaire météo : `http://localhost:9092/address`

##  Cloner le projet

git clone https://github.com/Abir-Kharmachi/Projet-DevOps.git

cd Projet-DevOps


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
http://localhost:9092/greeting

### Problèmes rencontrés
- Erreur de version Java dans GitHub Actions : le script CI utilisait une version de Java incompatible avec le projet. Résolu en définissant la bonne version.
- Erreur de chemin dans le Dockerfile : au début, les chemins relatifs dans le `Dockerfile` ne pointaient pas correctement vers les fichiers `.jar` générés par Maven. J’ai corrigé ça en ajustant le `COPY` pour viser le bon dossier `target/`.
