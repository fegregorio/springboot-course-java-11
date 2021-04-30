package com.madpezkoh.course.repositories;

import com.madpezkoh.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
