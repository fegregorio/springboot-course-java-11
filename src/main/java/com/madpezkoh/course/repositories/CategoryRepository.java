package com.madpezkoh.course.repositories;

import com.madpezkoh.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
