# Projet de Suivi de Gardes d'Enfants 

## Aperçu
Dans ce projet, vous développerez une application console destinée à une assistante maternelle pour la gestion de la garde d’enfants.
L'outil devra permettre la création de contrats, le suivi des heures d’arrivée et de départ, ainsi que la génération de récapitulatifs mensuels et de statistiques.
Le projet sera réalisé en Java avec une architecture multicouches respectant les bonnes pratiques de la programmation orientée objet.

## Fonctionnalités du Système  gg
- **Création de contrats** pour un ou plusieurs enfants
- **Suivi journalier des heures** (arrivée, départ, repas)
- **Récapitulatif mensuel** (heures travaillées, repas, montants dus)
- **Statistiques** sur la rémunération et l'accueil

## Technologies et Architecture

## Concepts de Programmation Orientée Objet
- **Agrégation** : Un parent lié à plusieurs contrats d’enfants
- **Cohésion** : Classe = responsabilité unique (Contrat, Enfant, Parent)
- **Héritage** : Extension possible des rôles utilisateur
- **Encapsulation** : Protection des données sensibles
- **Polymorphisme** : Comportements adaptés selon les entités

## Utilisation de Patrons de Conception
- **Factory** : Création de contrats ou de sessions de garde
- **Observer** : Notifications pour récapitulatifs mensuels
- **State** : Gestion des états de contrat
- **Strategy** : Calcul d'indemnités adaptées
- **Singleton** : Configuration centralisée
- **Facade** : Interface simplifiée pour l'UI

## Interface Utilisateur
- Code pour créer contrats, saisir les horaires, consulter les bilans et statistiques

## Livrables
- Code source complet organisé en modules
- Documentation d'architecture, d'utilisation des concepts POO et patrons de conception
- Instructions pour l'installation et l'utilisation de l'application