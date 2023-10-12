


Dans votre fichier pom.xml, vous avez déjà ajouté la dépendance pour la validation de Spring Boot avec l'artéfact spring-boot-starter-validation. Cette dépendance inclut les bibliothèques nécessaires pour la validation des données dans votre application.

Voici à quoi ressemble la partie de votre fichier pom.xml concernant la dépendance de validation :

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

## @Valid

If you have a parameter of type BindingResult it is essentially to hold any errors when binding http request parameters to a variable declared directly preceding the BindingResult method parameter.

So all of these is acceptable:

@RequestMapping(value = "/catowners", method = RequestMethod.GET)
public String findOwnersOfPetType(@Valid MyType type, BindingResult result, ...)


@RequestMapping(value = "/catowners", method = RequestMethod.GET)
public String findOwnersOfPetType(@ModelAttribute MyType type, BindingResult result, ...)

@RequestMapping(value = "/catowners", method = RequestMethod.GET)
public String findOwnersOfPetType(@RequestBody @Valid MyType type, BindingResult result, 


## Troobleshooting

* https://stackoverflow.com/questions/18646121/an-errors-bindingresult-argument-is-expected-to-be-declared-immediately-after-th



**  model.addAttribute("student", new Student()); // Ajoutez un nouvel objet Student au modèle

L'erreur "Neither BindingResult nor plain target object for bean name 'name' available as request attribute" indique que Spring ne peut pas trouver l'objet associé au nom name dans le modèle.

Pour résoudre ce problème, assurez-vous que vous ajoutez l'objet Student au modèle avant de rendre la vue. Dans votre contrôleur, assurez-vous d'ajouter un objet Student au modèle de la manière suivante :

java
Copy code
@GetMapping("/displayaddformstudents")
public String displayaddformStudents(Model model) {
    model.addAttribute("student", new Student()); // Ajoutez un nouvel objet Student au modèle
    return "addform-student";
}
Dans ce code, un nouvel objet Student est créé et ajouté au modèle avec le nom student. Ce nom doit correspondre à celui utilisé dans votre modèle Thymeleaf. Assurez-vous également que votre formulaire Thymeleaf fait référence correctement à cet objet student. Par exemple :

html
Copy code
<input type="text" class="form-control" id="name" name="name" th:field="*{student.name}" required>
<span th:if="${#fields.hasErrors('student.name')}" th:errors="*{student.name}" class="text-danger"></span>
Dans cet exemple, *{student.name} fait référence au champ name de l'objet Student dans votre modèle Thymeleaf. Assurez-vous que le nom de l'objet dans th:field correspond au nom de l'objet que vous avez ajouté au modèle dans votre contrôleur.

En résumé, assurez-vous que :

Vous ajoutez l'objet Student avec le nom student au modèle dans votre contrôleur.
Vous référencez correctement cet objet dans votre formulaire Thymeleaf avec th:field="*{student.name}" par exemple.