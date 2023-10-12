package com.macrosoft.starterjavaspringbootfull.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.macrosoft.starterjavaspringbootfull.model.Course;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}
