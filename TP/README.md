LINK GIT :https://github.com/Abir-Kharmachi/ProjetPOO/tree/master/TP_Abir_KHARMACHI

TP3:

ETAPE 5:

1-artifactID=spring-boot-starter-web: c'est la partie responsable sur le web dans le Spring framework. Elle nous permet de créer des applications web en se basant el l'architecture Spring mvc (Model-View-Controller) qui divise l’architecture sur ses trois parties :
-Modèle : le modèle contient les informations (données) utilisées par le système.
-Vue : la vue est la façon dont ces informations sont affichées pour l’utilisateur.
-Contrôleur : le contrôleur veille à ce que les demandes de l'utilisateur soient correctement exécutées, en modifiant les objets du modèle et en mettant à jour la vue.

2-Spring Data Jpa (spring-boot-starter-data-jpa):
Facilite l'intégration de Java Persistence API (JPA) pour gérer les bases de données relationnelles dans les applications Spring, permettant une gestion robuste des entités et une réduction de la quantité de code boilerplate nécessaire pour le modèle de données.

3-Hibernate : Hibernate est un composant très important dans les applications java qui sont basés sur les bases de données relationnelles. Il contient l'ORM qui sert à la conversion des data entre des systèmes multiples de POO avec des types différents. De plus il est le responsable sur la signalisation des entités Java (@Entity) et les annotation du mapping.

4-H2 : est un système de gestion des bases de données très rapide et compatible avec le développement en Java.Il permet de manipuler, query et la création des bases de données purement dans la mémoire, ce qui améliore l’accès) la base de données dans les différentes étapes du développement.

5-Devtools: est l'une des dépendances vitales dans un projet spring. Elle représente une partie de l'écosystème du spring boot qui contient un ensemble des 'tools' de développement

6-Thymeleaf: Thymeleaf est un moteur de template polyvalent capable de produire  du XML, du XHTML et de l'HTML5. Conçu à l'origine pour être utilisé dans des environnements web, Thymeleaf offre la possibilité d'être employé aussi bien dans des contextes web que non web. Son objectif principal demeure la génération de vues dans le cadre d'applications web reposant sur le modèle MVC.

ETAPE 13 :

1- Avec quelle partie du code avons-nous paramétré l'url d'appel /greeting ?
   L'URL /greeting est définie grâce à l'annotation @GetMapping("/greeting") présente dans la classe HelloWorldController.
   Cette annotation associe la méthode greeting() à l'URL spécifiée.

2- Avec quelle partie du code avons-nous choisi le fichier HTML à afficher ?
   Le fichier HTML à afficher est spécifié par la méthode greeting() qui retourne le nom "greeting".
   Spring Boot, avec Thymeleaf, recherche un fichier nommé greeting.html dans le dossier resources/templates.

3- Comment envoyons-nous le nom à qui nous disons bonjour avec le second lien ?
   Le nom est passé en tant que paramètre d'URL, par exemple :
   http://localhost:9091/greeting?name=ENSIM.
   Ce paramètre est capturé par l'annotation @RequestParam dans la méthode greeting(),
   et il est injecté dans le modèle avec model.addAttribute("nomTemplate", nameGET);.
   Ainsi, le fichier HTML utilise cette valeur via l'expression Thymeleaf ${nomTemplate}.


Etape 17 : 
Différences observées après avoir ajouté la classe 'Address'
Après avoir relancé l'application, j'ai remarqué la creation automatique d'une table nommée 'ADDRESS' dans la base de données H2.

Etape 18 :
Cette table a été créée par Hibernate grâce aux annotations JPA de la classe 'Address'.
Hibernate a mappé les propriétés de la classe aux colonnes suivantes :
- `id` → Colonne `ID` (clé primaire, générée automatiquement)
- `creation` → Colonne `CREATION`
- `content` → Colonne `CONTENT`

Étape 19 :
Pour insérer des données initiales dans la base de données H2, j'ai ajouté un fichier `data.sql` dans 'src/main/resources'.
Spring Boot charge automatiquement ce fichier au démarrage de l’application.
apres, tout les données sont insert dans la table 'Address'.

ETAPE 20 : on utilisant "SELECT * from address;" , on a constaté l'ajout des deux lignes dans la table qui contiennent les deux objets ajouter dans data.sql

ETAPE 22: @Autowired est utilisé principalement pour injecter les dépendances

ETAPE 30 :
1-le téléchargement du  Bootstrap
2-l'ajout du .css et .js dans le dossier ressources/static
3- A chaque besoin des  modifications avec le Bootstrap il suffit d'ajouter
"<link rel="stylesheet" href="/css/bootstrap.min.css">" dans la page html


TP4:

Etape 6 :
1-Oui ,il faut générer un token après la création d'un compte pour accéder à l'api MetetoConcept
2-"https://api.meteo-concept.com/api/forecast/daily/0?token=" + API_KEY + "&latlng=" + Latitute + "," + Longitude;
qui permet d'appeler l'api avec le token et en attribuant les coordonnées de la localisation souhaitée.
3/
la utilisée c'est: Méthode HTTP GET
4/
 Les paramètres d'appel sont 3:
-le token: qui nous permet d'accéder à l'api.
-latitude: qui contient la latitude récupérée avec l'api : https://geo.api.gouv.fr
-longitude: qui contient la longitude récupérée avec l'api : https://geo.api.gouv.fr
5-Après la récupération de la réponse :
-La température du lieu visé par les coordonnées GPS: existe dans le "body" de la réponse => Objet "forecast" et après dans les attributs: "tmin" et "tmax"
-La prévision de météo du lieu visé par les coordonnées GPS : de la même façon ,existe dans le "body" de la réponse => Objet "forecast"  et après dans les attributs tel que :probafog ,wind10m,sun_hours...
	
