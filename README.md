
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

### Intégration Continue (CI)
À chaque push sur la branche main :

 -Le projet est compilé (mvn clean install)

 -Une image Docker est construite et poussée

 -Un tag Git est généré automatiquement (v1.0.0) si non existant

 -Une simulation de déploiement est affichée

### Lancer le projet

docker compose pull
docker compose up -d
tester avec :
http://localhost:9092/greeting

### Problèmes rencontrés
Problèmes rencontrés
-Erreur de version Java : corrigé en passant à Java 21 dans Dockerfile et GitHub Actions.

-Conflit de tag Git : solution ajoutée pour ignorer si v1.0.0 existe déjà.

-Problème d’indentation YAML : corrigé dans docker-compose.yml avec un bon format ports.
