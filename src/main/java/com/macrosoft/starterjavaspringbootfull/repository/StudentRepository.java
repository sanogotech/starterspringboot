package com.macrosoft.starterjavaspringbootfull.repository;

import org.springframework.data.repository.CrudRepository;

import com.macrosoft.starterjavaspringbootfull.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}

