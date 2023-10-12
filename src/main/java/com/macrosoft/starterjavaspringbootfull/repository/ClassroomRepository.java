package com.macrosoft.starterjavaspringbootfull.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.macrosoft.starterjavaspringbootfull.model.Classroom;

public interface ClassroomRepository extends PagingAndSortingRepository<Classroom, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}
