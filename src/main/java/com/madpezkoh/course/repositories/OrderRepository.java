package com.madpezkoh.course.repositories;

import com.madpezkoh.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
