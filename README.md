# starterspringboot
Starter Spring Boot

## Projet École avec Spring Boot, Thymeleaf, et H2 Database

Ce projet est une application Web simple créée avec Spring Boot, Thymeleaf, Bootstrap, et H2 Database. Il permet de gérer une liste d'étudiants.

## Prérequis

- Java JDK 11+
- Apache Maven
- Git (facultatif, pour cloner le projet)

## Configuration de la Base de Données (Dev)

Dans le fichier `src/main/resources/application-dev.properties`, configurez la base de données H2 pour le profil de développement :

```properties
spring.datasource.url=jdbc:h2:mem:ecole_dev;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Activation de la console H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Activation des logs détaillés
logging.level.org.springframework.web=DEBUG
```

## Difference between @RequestParam vs @RequestBody

* Get :  @RequestParam

* Post + @Valid :  @RequestBody

https://tedblob.com/requestbody-vs-requestparam/


## Exécuter l'Application
Pour exécuter l'application, utilisez la commande Maven suivante :

```bash
mvn clean spring-boot:run
```

L'application sera accessible à l'adresse : http://localhost:8080

**Profil de Production**

Pour exécuter l'application en mode de production, créez un fichier src/main/resources/application-prod.properties avec les configurations de base de données appropriées pour votre environnement de production.

Activez le profil de production en modifiant le fichier src/main/resources/application.properties :

```properties
spring.profiles.active=prod
```

**Console H2**

En mode de développement, vous pouvez accéder à la console H2 à l'adresse : 
**http://localhost:8080/h2-console**. Les détails de connexion sont configurés dans application-dev.properties.
