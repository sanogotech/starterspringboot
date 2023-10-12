package com.macrosoft.starterjavaspringbootfull.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.macrosoft.starterjavaspringbootfull.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
	
	Page<Student> findByNameContainingIgnoreCase(String keyword, Pageable pageable);
}



