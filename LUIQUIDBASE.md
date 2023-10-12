# Utilisation de Liquibase
Liquibase est un outil puissant pour la gestion des schémas de base de données et les migrations. Voici comment vous pouvez l'utiliser dans votre projet Spring Boot :


## 1. Structure du Répertoire Liquibase

Assurez-vous que votre projet suit une structure de répertoire appropriée pour Liquibase. Par exemple :

```lua
src
|-- main
|   |-- resources
|       |-- db
|           |-- changelog
|               |-- db.changelog-master.yaml
```

**db.changelog-master.yaml** est le fichier principal de journalisation des modifications. Il contient les instructions SQL pour créer et mettre à jour votre base de données.

## 2. Configuration de Liquibase

Dans votre fichier application.properties ou application.yml, configurez Liquibase pour utiliser votre fichier de journalisation des modifications :

```properties

spring.liquibase.change-log=classpath:/db/changelog/db.changelog-master.yaml
```

Assurez-vous que le chemin dans spring.liquibase.change-log est correct et correspond à l'emplacement de votre fichier db.changelog-master.yaml.

## 3. Fichier db.changelog-master.yaml
Voici un exemple de contenu pour db.changelog-master.yaml :

```yaml
databaseChangeLog:
  - changeSet:
      id: 1
      author: votre_nom
      changes:
        - createTable:
            tableName: students
            columns:
              - column:
                  name: id
                  type: int
                  autoIncrement: true
                  constraints:
                    primaryKey: true
              - column:
                  name: name
                  type: varchar(255)
              - column:
                  name: grade
                  type: varchar(255)
  ```
  
Ce fichier crée une table students avec les colonnes id, name, et grade. Assurez-vous d'ajouter toutes les instructions SQL nécessaires pour votre schéma de base de données.

## 4. Exécuter Liquibase

Lorsque vous exécutez votre application Spring Boot, Liquibase détectera automatiquement le fichier de journalisation des modifications et appliquera les modifications nécessaires à votre base de données.

Assurez-vous de suivre ces étapes et de vérifier que votre fichier 

**db.changelog-master.yaml** est correctement configuré et contient les modifications appropriées pour votre base de données. Une fois que tout est configuré correctement, l'erreur que vous avez rencontrée ne devrait plus se produire.