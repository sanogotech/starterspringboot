package com.macrosoft.starterjavaspringbootfull.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.macrosoft.starterjavaspringbootfull.model.Teacher;

public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}
