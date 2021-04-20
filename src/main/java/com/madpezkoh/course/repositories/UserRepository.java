package com.madpezkoh.course.repositories;

import com.madpezkoh.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
