Projet de Suivi de Gardes d’Enfants

Application console développée en Java permettant à une assistante maternelle de gérer les contrats de garde d’enfants, le suivi des horaires, les repas ainsi que les récapitulatifs mensuels et statistiques.

📌 Objectif du Projet

Ce projet a été réalisé dans le but de mettre en pratique :

La programmation orientée objet (POO)
Une architecture multicouches
L’utilisation de plusieurs Design Patterns
La structuration d’une application Java maintenable et évolutive

L’application facilite la gestion quotidienne des gardes d’enfants grâce à un système de suivi simple et organisé. <br>

🚀 Fonctionnalités
Gestion des contrats
Création de contrats pour un ou plusieurs enfants
Association d’un parent à plusieurs contrats
Gestion des informations liées aux enfants et aux parents
Suivi journalier
Enregistrement des heures d’arrivée
Enregistrement des heures de départ
Suivi des repas pris par l’enfant
Récapitulatif mensuel
Calcul des heures travaillées
Calcul du nombre de repas
Estimation des montants dus
Statistiques
Analyse des rémunérations
Suivi de l’activité d’accueil
Consultation des données globales <br>
🏗️ Architecture du Projet

Le projet suit une architecture multicouches afin de séparer les responsabilités :

Couche Modèle : gestion des entités métier
Couche Service : logique applicative
Couche Interface Console : interactions utilisateur
Couche Utilitaire : gestion des calculs et outils communs

Cette organisation améliore :

la lisibilité du code,
la maintenance,
l’évolutivité du projet. <br>
💡 Concepts de Programmation Orientée Objet Utilisés
Encapsulation

Protection des données sensibles grâce aux attributs privés et aux accesseurs.

Agrégation

Un parent peut être lié à plusieurs contrats d’enfants.

Cohésion

Chaque classe possède une responsabilité unique :

Contrat
Enfant
Parent
SessionGarde
Héritage

Possibilité d’étendre certains comportements utilisateur.

Polymorphisme

Adaptation des comportements selon les types d’entités manipulées. <br>

🧩 Design Patterns Utilisés
Factory Pattern

Création centralisée des contrats et sessions de garde.

Singleton Pattern

Gestion d’une configuration unique de l’application.

Strategy Pattern

Calcul flexible des indemnités et rémunérations.

State Pattern

Gestion des différents états d’un contrat.

Observer Pattern

Notification automatique lors de la génération des récapitulatifs.

Facade Pattern

Simplification des interactions entre les différentes couches de l’application.<br>

🛠️ Technologies Utilisées
Java
Programmation Orientée Objet
Architecture multicouches
Console Java <br>
📂 Structure Possible du Projet
src/<br>
│ <br>
├── model/<br>
├── service/<br>
├── factory/<br>
├── strategy/<br>
├── observer/<br>
├── state/<br>
├── facade/<br>
├── ui/<br>
└── Main.java <br><br>
▶️ Installation et Exécution
Prérequis
Java JDK 17 ou supérieur
IDE Java :
IntelliJ IDEA
Eclipse IDE
NetBeans
Étapes
Cloner le projet :
git clone <url-du-repository>
Ouvrir le projet dans votre IDE Java.
Compiler puis exécuter le fichier :
Main.java <br>
📖 Exemple d’Utilisation
Création d’un contrat
1. Ajouter un parent
2. Ajouter un enfant
3. Créer un contrat
Saisie des horaires
- Heure d’arrivée : 08h00
- Heure de départ : 17h30
- Repas : Oui
Génération d’un récapitulatif
- Total heures : 160h
- Total repas : 18
- Montant dû : 950€ <br>
📄 Documentation

Le projet contient :

le code source complet,
l’explication des concepts POO utilisés,
les Design Patterns implémentés,
les instructions d’utilisation.<br>
🎯 Compétences Développées
Conception orientée objet
Structuration d’une application Java
Mise en place d’une architecture multicouches
Utilisation de Design Patterns
Gestion de données et logique métier
